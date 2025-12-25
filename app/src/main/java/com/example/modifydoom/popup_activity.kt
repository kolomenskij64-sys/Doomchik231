package com.example.modifydoom // тот же пакет!

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PopupActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_layout)

            // Кнопка "Закрыть"
            val btnClose = findViewById<View>(R.id.btn2_clos) as Button
            btnClose.setOnClickListener {
                finish()

                }

            }

        }




