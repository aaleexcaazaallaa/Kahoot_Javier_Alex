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
    private lateinit var edOpcion1: EditText
    private lateinit var edOpcion2: EditText
    private lateinit var edOpcion3: EditText
    private lateinit var edOpcion4: EditText
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
        val opcion1 = edOpcion1.text.toString()
        val opcion2 = edOpcion2.text.toString()
        val opcion3 = edOpcion3.text.toString()
        val opcion4 = edOpcion4.text.toString()
        val opcionCorrecta = edOpcionCorrecta.text.toString()

        if (pregunta.isEmpty() || opcion1.isEmpty() || opcion2.isEmpty() || opcion3.isEmpty() || opcion4.isEmpty() || opcionCorrecta.isEmpty()) {
            Toast.makeText(this, "Aun quedan campos por rellenar", Toast.LENGTH_LONG).show()
        } else if (!opcionCorrecta.equals(opcion1) && !opcionCorrecta.equals(opcion2) && !opcionCorrecta.equals(opcion3) && !opcionCorrecta.equals(opcion4)) {
            Toast.makeText(this, "Esa opcion no puede ser una respuesta correcta", Toast.LENGTH_LONG).show()
        } else {
            lifecycleScope.launch {
                val preguntaGuardada = Kahoot(pregunta = pregunta, primera_respuesta = opcion1, segunda_respuesta = opcion2, tercera_respuesta = opcion3, cuarta_respuesta = opcion4, respuesta_correcta = opcionCorrecta)
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
        edOpcion1.setText("")
        edOpcion2.setText("")
        edOpcion3.setText("")
        edOpcion4.setText("")
        edOpcionCorrecta.setText("")
        edPregunta.requestFocus()
    }

    private fun initView() {
        edPregunta = findViewById(R.id.edPregunta)
        edOpcion1 = findViewById(R.id.edOpcion1)
        edOpcion2 = findViewById(R.id.edOpcion2)
        edOpcion3 = findViewById(R.id.edOpcion3)
        edOpcion4 = findViewById(R.id.edOpcion4)
        edOpcionCorrecta = findViewById(R.id.edOpcionCorrecta)
        btnGuardarPregunta = findViewById(R.id.btnGuardarPregunta)
        btnVolver = findViewById(R.id.btnVolver)
    }
}