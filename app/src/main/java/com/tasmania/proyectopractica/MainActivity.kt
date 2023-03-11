package com.tasmania.proyectopractica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Switch
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    var campoNombre:EditText?=null
    var campoEdad:EditText?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageButton>(R.id.imageButton)
        var imageButtonState: Boolean = false
        var estadoImage: String = ""

        campoNombre=findViewById(R.id.nombre)
        campoEdad=findViewById(R.id.edad)

        image.setOnClickListener {
            imageButtonState = !imageButtonState
            if (imageButtonState) {
                estadoImage="Imagen encendida"
            } else {
                estadoImage="Imagen apagada"
            }
        }

        val botonCalcular: Button=findViewById(R.id.button)
        botonCalcular.setOnClickListener({realizarCalculo(estadoImage)})
    }

    private fun realizarCalculo(estadoImage: String) {
        var textoCompleto: String = ""
        var nombre: String = campoNombre!!.text.toString()
        var edad: Int = campoEdad!!.text.toString().toInt()

        val checkBoxP1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBoxP2 = findViewById<CheckBox>(R.id.checkBox2)
        val radioButton1 = findViewById<RadioButton>(R.id.radio1)
        val radioButton2 = findViewById<RadioButton>(R.id.radio2)
        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        val switch1 = findViewById<Switch>(R.id.switch1)

        if(radioButton1.isChecked){
            textoCompleto+="Radio 1 seleccionado\n"
        }
        if(radioButton2.isChecked){
            textoCompleto+="Radio 2 seleccionado\n"
        }
        if(checkBoxP1.isChecked){
            textoCompleto+="Check 1 seleccionado\n"
        }
        if(checkBoxP2.isChecked){
            textoCompleto+="Check 2 seleccionado\n"
        }
        if(toggleButton.isChecked){
            textoCompleto+="ToggleButton seleccionado\n"
        }
        if(switch1.isChecked){
            textoCompleto+="Switch seleccionado\n"
        }

        textoCompleto+="${nombre}\n"
        textoCompleto+="${edad}\n"
        textoCompleto+="${estadoImage}\n"

        Toast.makeText(this, "${textoCompleto}", Toast.LENGTH_LONG).show()
    }
}