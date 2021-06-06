package com.example.medicationapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent;


class MainActivity : AppCompatActivity () {
    private lateinit var helloText: TextView
    private lateinit var helloText2: TextView
    private lateinit var frame1: FrameLayout
    private lateinit var button1: Button
    private lateinit var button2: ImageButton
    private lateinit var button3: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloText = findViewById(R.id.helloText)
        helloText2 = findViewById(R.id.helloText2)
        frame1 = findViewById(R.id.frame1)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        val buttonOne: Button = findViewById(R.id.button1)
        buttonOne.setOnClickListener {
            val intent = Intent(this, TodaysMedicine :: class.java)
            startActivity(intent)
        }
       // val buttonTwo: ImageButton = findViewById(R.id.button2)
        //buttonOne.setOnClickListener {
          //  val intent = Intent(this, AddMedicine::class.java)
            //startActivity(intent)
        //}

        val buttonThree: Button = findViewById(R.id.button3)
        buttonThree.setOnClickListener {
            val intent = Intent(this, HealthCondition::class.java)
            startActivity(intent)
        }

    }
}