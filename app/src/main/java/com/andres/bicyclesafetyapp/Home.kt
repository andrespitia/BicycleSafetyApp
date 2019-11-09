package com.andres.bicyclesafetyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.android.synthetic.main.activity_main.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val  btescanear = findViewById<Button>(R.id.btescanear)
        val  btregistrar = findViewById<Button>(R.id.btregistrar)
        val oIntent4 = Intent(this, RegistrarBicicleta::class.java)
        val oIntent3 = Intent(this, Escanear::class.java)

        btregistrar.setOnClickListener(View.OnClickListener {
            startActivity(oIntent4)
        })
        btescanear.setOnClickListener(View.OnClickListener {
            startActivity(oIntent3)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val oIntent = Intent(this, MainActivity::class.java)
        val oIntent2 = Intent(this, Perfil::class.java)

        when (item.itemId) {
            R.id.cerrar -> {
                Toast.makeText(this, "salir", Toast.LENGTH_LONG).show()
                startActivity(oIntent)
                return true
            }
            R.id.perfil -> {
                Toast.makeText(this, "perfil", Toast.LENGTH_LONG).show()
                startActivity(oIntent2)

                return true
            }


        }
        return super.onOptionsItemSelected(item)

    }
}
