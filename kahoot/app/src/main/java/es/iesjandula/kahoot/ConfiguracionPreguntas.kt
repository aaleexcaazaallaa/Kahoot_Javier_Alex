package es.iesjandula.kahoot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlin.math.log

class ConfiguracionPreguntas : AppCompatActivity() {

    val app = KahootApp

    private lateinit var edPregunta: EditText
    private lateinit var edOpcionErronea1: EditText
    private lateinit var edOpcionErronea2: EditText
    private lateinit var edOpcionErronea3: EditText
    private lateinit var edOpcionCorrecta: EditText
    private lateinit var btnGuardarPregunta: Button
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion_preguntas)

        initView()
        btnGuardarPregunta.setOnClickListener { guardarPregunta() }
        btnVolver.setOnClickListener {
            val intentVolver = Intent(this, MainActivity::class.java)
            startActivity(intentVolver)
        }
    }

    private fun guardarPregunta() {
        val pregunta = edPregunta.text.toString()
        val opcionErronea1 = edOpcionErronea1.text.toString()
        val opcionErronea2 = edOpcionErronea2.text.toString()
        val opcionErronea3 = edOpcionErronea3.text.toString()
        val opcionCorrecta = edOpcionCorrecta.text.toString()

        if (pregunta.isEmpty() || opcionErronea1.isEmpty() || opcionErronea2.isEmpty() || opcionErronea3.isEmpty() || opcionCorrecta.isEmpty()) {
            Toast.makeText(this, "Aun quedan campos por rellenar", Toast.LENGTH_LONG).show()
        } else {
            lifecycleScope.launch {
                val preguntaGuardada = Kahoot(pregunta = pregunta, primera_respuesta = opcionErronea1, segunda_respuesta = opcionErronea2, tercera_respuesta = opcionErronea3, cuarta_respuesta = opcionCorrecta)
                val preguntasList: List<Kahoot> = listOf(preguntaGuardada)
                app.room.kahootDao().insertKahoot(preguntasList)
                Log.e("valor", "$preguntaGuardada")
            }
            Toast.makeText(this, "Pregunta guardada con exito", Toast.LENGTH_LONG).show()
            clearEditText()
        }

    }

    private fun clearEditText() {
        edPregunta.setText("")
        edOpcionErronea1.setText("")
        edOpcionErronea2.setText("")
        edOpcionErronea3.setText("")
        edOpcionCorrecta.setText("")
        edPregunta.requestFocus()
    }

    private fun initView() {
        edPregunta = findViewById(R.id.edPregunta)
        edOpcionErronea1 = findViewById(R.id.edOpcionErronea1)
        edOpcionErronea2 = findViewById(R.id.edOpcionErronea2)
        edOpcionErronea3 = findViewById(R.id.edOpcionErronea3)
        edOpcionCorrecta = findViewById(R.id.edOpcionCorrecta)
        btnGuardarPregunta = findViewById(R.id.btnGuardarPregunta)
        btnVolver = findViewById(R.id.btnVolver)
    }
}