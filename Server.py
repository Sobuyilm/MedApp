#Import stuff
from flask import Flask
import pytesseract as tess
from PIL import Image
import spacy
import requests
from flask import Flask, request, jsonify

med7 = spacy.load("en_core_med7_lg")
app = Flask(__name__)

@app.route("/im", methods=["POST"])
def process_image():
    file = request.files['image']

    #Read the image via file.stream
    img = Image.open(file.stream)
    text = tess.image_to_string(img)

    #Break down text into array
    doc = med7(text)
    spacy.displacy.render(doc, style='ent')

    #Extract drug from array
    analysis = [(ent.text, ent.label_) for ent in doc.ents]
    drug = analysis[0]
    Medizin = drug[0]

    #Dosage&Administration
    response = requests.get("https://api.fda.gov/drug/label.json?search=dosage_and_administration:" + Medizin)

    #Only show relevant information
    for data in (response.json()["results"]):
        DosageAndAdministration = data["dosage_and_administration"]
    return jsonify({'str': DosageAndAdministration})


if __name__ == "__main__":
    app.run()
