
package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    var home_selected: Boolean = false

    lateinit var card_home: MaterialCardView
    lateinit var card_dona: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        card_home = findViewById(R.id.seleccio_home)
        card_dona = findViewById(R.id.seleccio_dona)

        card_home.setOnClickListener {
            card_home.setCardBackgroundColor(Color.RED)
            card_dona.setCardBackgroundColor(Color.WHITE)
            home_selected = true
        }

        card_dona.setOnClickListener(::card_click)
    }

    fun card_click(it: View) {
        card_dona.setCardBackgroundColor(Color.RED)
        card_home.setCardBackgroundColor(Color.WHITE)
        home_selected = false
    }
}

