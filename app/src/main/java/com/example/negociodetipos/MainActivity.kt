package com.example.negociodetipos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMonto = findViewById<EditText>(R.id.etMonto)
        val rbContado = findViewById<RadioButton>(R.id.rbContado)
        val rbPlazos = findViewById<RadioButton>(R.id.rbPlazos)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        val rbPublico = findViewById<RadioButton>(R.id.rbPublico)
        val rbAfiliado = findViewById<RadioButton>(R.id.rbAfiliado)

        btnCalcular.setOnClickListener {
            if (etMonto.text.toString().isEmpty()) {
                etMonto.setError("Ingrese un monto de compra")
            } else {
                var monto: Double = etMonto.text.toString().toDouble()
                var total = 0.0
                var desc = 0.0
                var recargo = 0.0

                if (rbPublico.isChecked) {
                    if (rbContado.isChecked) {
                        desc = monto * 0.15
                        total = monto - desc
                    } else {
                        recargo = monto * 0.10
                        total = monto * recargo
                    }
                }

                if (rbAfiliado.isChecked) {
                    if (rbContado.isChecked) {
                        desc = monto * 0.20
                        total = monto - desc
                    } else {

                        recargo = monto * 0.05
                        total = monto * recargo
                    }
                }

                tvTotal.setText("Total a pagar: \nS/. ${total}")
            }
        }
    }
}