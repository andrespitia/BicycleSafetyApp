package com.andres.bicyclesafetyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_escanear.*


class Escanear : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escanear)

        initFunc()
        val  btregistrar = findViewById<ImageView>(R.id.ivSiguiente)
        val oIntent = Intent(this, Datos::class.java)

        ivSiguiente.setOnClickListener(View.OnClickListener {
            startActivity(oIntent)
        })
    }

    private fun initFunc(){

        btEscaner.setOnClickListener({
            IntentIntegrator(this).initiateScan()
        })
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result =IntentIntegrator.parseActivityResult(requestCode,resultCode,data)

        if (result != null){
            if (result.contents == null){
                Toast.makeText(this, "El dato es vacio", Toast.LENGTH_LONG).show()
            }else{
                etvistaescaneo.setText(result.contents.toString())
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }



}

