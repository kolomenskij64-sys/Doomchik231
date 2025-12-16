package com.example.hd2wartracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ProgressBar
import android.animation.ObjectAnimator

class moc_screen : Activity() {

    private lateinit var buttons:List<ImageButton>
    private lateinit var progressBar: ProgressBar

    private val pressed = mutableSetOf<Int>()

    private val pressedImages = listOf(
        R.drawable.shootgun,
        R.drawable.triple_mod,
        R.drawable.pop,
        R.drawable.gauss,
        R.drawable.plasma,
        R.drawable.rocket,
        R.drawable.plasma,
        R.drawable.plasma_mod1,
        R.drawable.plasma_mod2,
        R.drawable.patron_plasma,
        R.drawable.moc_p2_4d,
        R.drawable.moc_p2_5d,
        R.drawable.moc_p3_1d,
        R.drawable.moc_p3_2d,
        R.drawable.moc_p2_1d,
        R.drawable.moc_p3_6d,
        R.drawable.moc_p3_4d,
        R.drawable.moc_p3_5d,

        )
    private val normalImages = listOf(
        R.drawable.shootgun,
        R.drawable.triple_mod,
        R.drawable.pop,
        R.drawable.gauss,
        R.drawable.plasma,
        R.drawable.rocket,
        R.drawable.plasma,
        R.drawable.plasma_mod1,
        R.drawable.plasma_mod2,
        R.drawable.patron_plasma,
        R.drawable.moc_p2_4,
        R.drawable.moc_p2_5,
        R.drawable.moc_p3_1,
        R.drawable.moc_p3_4,
        R.drawable.moc_p3_5,
        R.drawable.moc_p3_3,
        R.drawable.moc_p3_2,
        R.drawable.moc_p3_6,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moc_lay)

        val btnSwitch = findViewById<ImageButton>(R.id.moc_backbutton)
        progressBar = findViewById(R.id.moc_progressbar)

        buttons = listOfNotNull(
            findViewById<ImageButton>(R.id.p1_item_center),
            findViewById<ImageButton>(R.id.p1_item4),
            findViewById<ImageButton>(R.id.p2_item1),
            findViewById<ImageButton>(R.id.p2_item2),
            findViewById<ImageButton>(R.id.p2_item3),
            findViewById<ImageButton>(R.id.p2_item_center),
            findViewById<ImageButton>(R.id.p2_item4),
            findViewById<ImageButton>(R.id.p2_item5),
            findViewById<ImageButton>(R.id.p3_item1),
            findViewById<ImageButton>(R.id.p3_item2),
            findViewById<ImageButton>(R.id.p3_item3),
            findViewById<ImageButton>(R.id.p3_item_center),
            findViewById<ImageButton>(R.id.p3_item4),
            findViewById<ImageButton>(R.id.p3_item5)
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

        if (pressed.contains(index)) {
            pressed.remove(index)
            button.setImageResource(normalImages[index])
        }
        else{
            pressed.add(index)
            button.setImageResource(pressedImages[index])
        }


        val part = 100f / buttons.size
        val newProgress = (pressed.size * part).toInt()

        animateProgressBar(progressBar, newProgress, 300)

    }
    private fun animateProgressBar(progressBar: ProgressBar,toProgress: Int, duration: Long){
        val animator = ObjectAnimator.ofInt(progressBar,"progress",progressBar.progress, toProgress)
        animator.duration = duration
        animator.start()
    }
}
