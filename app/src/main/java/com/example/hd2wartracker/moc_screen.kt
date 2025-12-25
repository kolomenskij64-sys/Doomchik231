package com.example.hd2wartracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ProgressBar
import android.animation.ObjectAnimator
import android.util.Log

class moc_screen : Activity() {

    private lateinit var buttons: List<ImageButton>

    private val pressed = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moc_lay)

        val btnSwitch = findViewById<ImageButton>(R.id.moc_backbutton)


        buttons = listOfNotNull(
            findViewById<ImageButton>(R.id.p1_item_center),


            findViewById<ImageButton>(R.id.p2_item3),
            findViewById<ImageButton>(R.id.p2_item_center),


            findViewById<ImageButton>(R.id.p3_item1),


            findViewById<ImageButton>(R.id.p3_item_center),

            )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                handleButtonPress(index, button)

            }
        }

        btnSwitch.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun handleButtonPress(index: Int, button: ImageButton) {


        val part = 100f / buttons.size
        val newProgress = (pressed.size * part).toInt()


        findViewById<ImageButton>(R.id.p1_item_center)?.setOnClickListener {
            Log.d("CLICK", "ImageButton нажат! Запускаю PopupActivity...")
            val intent = Intent(this, PopupActivity::class.java)
            startActivity(intent)

            findViewById<ImageButton>(R.id.p2_item_center).setOnClickListener {
                val intent = Intent(this, PopupActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}
