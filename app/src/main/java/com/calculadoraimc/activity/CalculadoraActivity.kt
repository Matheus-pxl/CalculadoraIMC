// CalculadoraIMCActivity.kt
package com.calculadoraimc.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.calculadoraimc.R
import kotlin.math.pow

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        // Inicializa views
        editTextPeso = findViewById(R.id.editPeso)
        editTextAltura = findViewById(R.id.editAltura)
        buttonCalcular = findViewById(R.id.btCalcular)
        textViewResultado = findViewById(R.id.viewResult)

        // Configura listener para o botão de calcular
        buttonCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        // Obtém os valores inseridos nos EditTexts
        val pesoStr = editTextPeso.text.toString()
        val alturaStr = editTextAltura.text.toString()

        if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
            val peso = pesoStr.toDouble()
            val altura = alturaStr.toDouble()

            // Calcula o IMC
            val imc = peso / altura.pow(2)

            // Exibe o resultado formatado
            exibirResultado(imc)
        }
    }

    private fun exibirResultado(imc: Double) {
        val resultado = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25 -> "Peso normal"
            imc < 30 -> "Sobrepeso"
            else -> "Obesidade"
        }

        textViewResultado.text = getString(R.string.resultado_imc, imc, resultado)
    }
}
