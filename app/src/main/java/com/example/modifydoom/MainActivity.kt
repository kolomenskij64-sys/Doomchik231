package com.example.modifydoom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSwitch = findViewById<ImageButton>(R.id.moc_button)
        val btnVc = findViewById<ImageButton>(R.id.vc_button)
        val btnUl = findViewById<ImageButton>(R.id.url_button)
        val uiScreen = findViewById<ImageButton>(R.id.ui_button)

        btnSwitch.setOnClickListener {
            val intent = Intent(this, moc_screen::class.java)


            startActivity(intent)
        }

        btnVc.setOnClickListener {
            val intent = Intent(this, vc_screen::class.java)



            startActivity(intent)
        }


        btnUl.setOnClickListener {
            val intent = Intent(this, ul_screen::class.java)



            startActivity(intent)
        }
        uiScreen.setOnClickListener {
            val intent = Intent(this, ui_screen::class.java)


            startActivity(intent)
        }

        }
    }

