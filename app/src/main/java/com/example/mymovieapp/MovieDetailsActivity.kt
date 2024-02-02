package com.example.mymovieapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieDetailsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_details)

        val receivedValue = intent.getStringExtra("title")


        val btnBack = findViewById<TextView>(R.id.back_tv)
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val btnBack2 = findViewById<ImageView>(R.id.back)
        btnBack2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val title:TextView = findViewById(R.id.title)
        title.text=receivedValue.toString()


    }
}