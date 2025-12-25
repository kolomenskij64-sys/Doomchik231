package com.example.modifydoom // тот же пакет!

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PopupActivity2 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_layout2)

        // Кнопка "Закрыть"
        val btnClose = findViewById<View>(R.id.layout_popup_close2) as Button
        btnClose.setOnClickListener {
            finish()

        }

    }

}




