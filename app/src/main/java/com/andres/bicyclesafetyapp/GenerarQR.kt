package com.andres.bicyclesafetyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_bicicleta.*

class GenerarQR : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generar_qr)

        val  btGuardar = findViewById<Button>(R.id.btGuardar)
        val  btEnviarcorreo = findViewById<Button>(R.id.btEnviarcorreo)

        val oIntent = Intent(this, Home::class.java)

        btGuardar.setOnClickListener(View.OnClickListener {
            //ir de una actividad a otra
            Toast.makeText(this, "El codigo fue guardado en su telefono", Toast.LENGTH_LONG).show()
            startActivity(oIntent)

        })
        btEnviarcorreo.setOnClickListener(View.OnClickListener {
            //ir de una actividad a otra
            Toast.makeText(this, "El codigo fue enviado a su email", Toast.LENGTH_LONG).show()
            startActivity(oIntent)

        })
    }
}
