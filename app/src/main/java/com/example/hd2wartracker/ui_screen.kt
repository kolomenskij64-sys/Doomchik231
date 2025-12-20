package com.example.hd2wartracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ProgressBar
import android.animation.ObjectAnimator

class ui_screen : Activity() {

    private lateinit var buttons:List<ImageButton>

    private val pressed = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_lay)

        val uiScreen = findViewById<ImageButton>(R.id.moc_backbutton)


        buttons = listOfNotNull(
            findViewById<ImageButton>(R.id.rocket_p1),



            findViewById<ImageButton>(R.id.rocket_p2),
            findViewById<ImageButton>(R.id.rocket_p3),

            )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                handleButtonPress(index, button)

            }
        }

        uiScreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
    private fun handleButtonPress(index: Int, button: ImageButton) {


        val part = 100f / buttons.size
        val newProgress = (pressed.size * part).toInt()



    }
}
