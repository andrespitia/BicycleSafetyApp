package com.andres.bicyclesafetyapp

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_bicicleta.*
import java.util.jar.Manifest

class RegistrarBicicleta : AppCompatActivity() {

    private val REQUEST_GALERIA =1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_bicicleta)


        val  btListo = findViewById<Button>(R.id.btlistoreg)
        val oIntent = Intent(this, GenerarQR::class.java)
        btListo.setOnClickListener(View.OnClickListener {

            //ir de una actividad a otra
            if (validaDatos(etTB)&& validaDatos(etMarca)&& validaDatos(etNM)&& validaDatos(etAnio) && validaDatos(etTamanio) && validaDatos(etColor) && validaDatos(etNS) && validaDatos(etDC) ) {
                startActivity(oIntent)

            }else{
                Toast.makeText(this, "Los datos son obligatorios", Toast.LENGTH_LONG).show()
            }
        })

        abreGaleria_clic()
    }

    fun validaDatos( dato: EditText):Boolean {
        if (dato.text.isNullOrEmpty()) {

            return false
        } else {
            return true
        }
    }

    private fun abreGaleria_clic(){
        ivgaleria1.setOnClickListener({
            //verificamos que version de android tiene el telefono
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                //pedir o verificar si tiene permiso de abrir la galeria
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                    //pedir permiso al usuario
                    val permisoarchivos = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoarchivos,REQUEST_GALERIA)
                }else {
                    muestragaleria()
                }
                }else{
                //tiene la version necesario o las siguientes
                    muestragaleria()
                }
        })

    }
    //miramos si el usuario acepto el permiso
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_GALERIA ->{
                if (grantResults[0]==PackageManager.PERMISSION_DENIED){
                    muestragaleria()
                }else{
                    Toast.makeText(this, "No puedes acceder a tus imagenes", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
    //abre la galeria
    private fun muestragaleria(){
        val oIntentGaleria = Intent(Intent.ACTION_PICK)
        oIntentGaleria.type= "image/*"
        startActivityForResult(oIntentGaleria,REQUEST_GALERIA)
        Toast.makeText(this, "aqui imagenes", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Activity.RESULT_OK && requestCode==REQUEST_GALERIA){
            ivgaleria1.setImageURI(data?.data)

        }
    }


}
