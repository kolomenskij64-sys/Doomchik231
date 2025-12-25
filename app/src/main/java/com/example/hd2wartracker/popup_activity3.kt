package com.example.hd2wartracker // тот же пакет!

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.compose.ui.graphics.Color

class PopupActivity3 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_layout3)

        // Кнопка "Закрыть"
        val btnClose = findViewById<View>(R.id.layout_popup_close3) as Button
        btnClose.setOnClickListener {
            finish()

        }

    }

}




