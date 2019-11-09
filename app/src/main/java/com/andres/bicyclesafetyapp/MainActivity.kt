package com.andres.bicyclesafetyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val  btIngreso = findViewById<Button>(R.id.btIngreso)

        val oIntent = Intent(this, Home::class.java)
        val oIntent2 = Intent(this, Registrarse::class.java)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        var mensaje = "Porfavor ingrese los datos dato"

        btIngreso.setOnClickListener(View.OnClickListener {
            //ir de una actividad a otra
            if (validaDatos(etUsuario) && validaDatos(etPassword) ) {
            startActivity(oIntent)
        }else{
            Toast.makeText(this, "Los datos son obligatorios", Toast.LENGTH_LONG).show()
        }
        })

        tvCrear.setOnClickListener(View.OnClickListener {
            startActivity(oIntent2)
        })
    }

    fun validaDatos( dato: EditText):Boolean {
        if (dato.text.isNullOrEmpty()) {

            return false
        } else {
            return true
        }
    }
}
