package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean? = null
    private var pes = 70
    private var edat = 18

    private lateinit var cardMale: MaterialCardView
    private lateinit var cardFemale: MaterialCardView

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
                0
            )
            insets
        }

        cardMale = findViewById(R.id.seleccio_home)
        cardFemale = findViewById(R.id.seleccio_dona)

        val alturaText = findViewById<TextView>(R.id.altura_text)
        val alturaSeekBar = findViewById<SeekBar>(R.id.altura_seekbar)
        val pesText = findViewById<TextView>(R.id.pes_text)
        val edatText = findViewById<TextView>(R.id.edat_text)

        val pesMenys = findViewById<Button>(R.id.pes_menys)
        val pesMes = findViewById<Button>(R.id.pes_mes)
        val edatMenys = findViewById<Button>(R.id.edat_menys)
        val edatMes = findViewById<Button>(R.id.edat_mes)
        val calcular = findViewById<Button>(R.id.calcular)

        resetSelection()

        cardMale.setOnClickListener {
            setGender(true)
        }

        cardFemale.setOnClickListener {
            setGender(false)
        }

        alturaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                alturaText.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        pesMenys.setOnClickListener {
            if (pes > 1) {
                pes--
                pesText.text = pes.toString()
            }
        }

        pesMes.setOnClickListener {
            pes++
            pesText.text = pes.toString()
        }

        edatMenys.setOnClickListener {
            if (edat > 1) {
                edat--
                edatText.text = edat.toString()
            }
        }

        edatMes.setOnClickListener {
            edat++
            edatText.text = edat.toString()
        }

        calcular.setOnClickListener {
            val alturaEnMetres = alturaSeekBar.progress / 100.0
            val imc = pes / (alturaEnMetres * alturaEnMetres)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("imc", imc)
            startActivity(intent)
        }
    }

    private fun resetSelection() {
        isMaleSelected = null
        val colorUnselected = Color.parseColor("#111328")
        cardMale.setCardBackgroundColor(colorUnselected)
        cardFemale.setCardBackgroundColor(colorUnselected)
    }

    private fun setGender(isMale: Boolean) {
        isMaleSelected = isMale
        val colorSelected = Color.parseColor("#6C63FF")
        val colorUnselected = Color.parseColor("#111328")

        if (isMale) {
            cardMale.setCardBackgroundColor(colorSelected)
            cardFemale.setCardBackgroundColor(colorUnselected)
        } else {
            cardMale.setCardBackgroundColor(colorUnselected)
            cardFemale.setCardBackgroundColor(colorSelected)
        }
    }
}