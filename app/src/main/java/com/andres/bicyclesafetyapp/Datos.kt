package com.andres.bicyclesafetyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_datos.*
import kotlinx.android.synthetic.main.activity_escanear.*

class Datos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        val  btdatos2 = findViewById<Button>(R.id.btDatos2)
        val oIntent = Intent(this, Home::class.java)


        btdatos2.setOnClickListener(View.OnClickListener {
            startActivity(oIntent)
            Toast.makeText(this, "Consulta existosa", Toast.LENGTH_LONG).show()
        })
    }
}
