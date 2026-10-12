
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
        val descripcion = findViewById<TextView>(R.id.descripcio_imc)
        val volver = findViewById<Button>(R.id.tornar)

        resultado.text = String.format("%.2f", imc)

        when {
            imc < 18.5 -> {
                categoria.text = "PES BAIX"
                descripcion.text = "El teu IMC està per sota del rang habitual."
            }
            imc < 25 -> {
                categoria.text = "PES NORMAL"
                descripcion.text = "El teu IMC està dins del rang habitual."
            }
            imc < 30 -> {
                categoria.text = "SOBREPÈS"
                descripcion.text = "El teu IMC està per sobre del rang habitual."
            }
            else -> {
                categoria.text = "OBESITAT"
                descripcion.text = "El teu IMC està molt per sobre del rang habitual."
            }
        }

        volver.setOnClickListener {
            finish()
        }
    }
}

