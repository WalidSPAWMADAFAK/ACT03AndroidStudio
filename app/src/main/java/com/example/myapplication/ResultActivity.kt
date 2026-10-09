
package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

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

        val imc = intent.getDoubleExtra("imc", 0.0)

        val resultado = findViewById<TextView>(R.id.resultat_imc)
        val categoria = findViewById<TextView>(R.id.categoria_imc)
        val volver = findViewById<Button>(R.id.tornar)

        resultado.text = String.format("%.2f", imc)

        categoria.text = when {
            imc < 18.5 -> "PES BAIX"
            imc < 25 -> "PES NORMAL"
            imc < 30 -> "SOB REPES"
            else -> "OBESITAT"
        }

        volver.setOnClickListener {
            finish()
        }
    }
}

