package com.andres.bicyclesafetyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Registrarse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val  btRegistrar = findViewById<Button>(R.id.btRegistrar)
        val oIntent = Intent(this, MainActivity::class.java)

        val etUsuario2 = findViewById<EditText>(R.id.etUsuario2)
        val etPassword2 = findViewById<EditText>(R.id.etPassword2)
        val etPassword3 = findViewById<EditText>(R.id.etPassword3)


        btRegistrar.setOnClickListener(View.OnClickListener {
            //ir de una actividad a otra
            if (validaDatos(etUsuario2) && validaDatos(etPassword2) && validaDatos(etPassword3)) {
                startActivity(oIntent)
            }else{
                Toast.makeText(this, "Los datos son obligatorios", Toast.LENGTH_LONG).show()
            }
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
