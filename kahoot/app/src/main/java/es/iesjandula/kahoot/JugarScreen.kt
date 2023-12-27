package es.iesjandula.kahoot

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class JugarScreen : AppCompatActivity() {

    private val app = KahootApp
    private var num = 0
    private var questionsList: List<Kahoot> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_jugar_screen)

        var pregunta = findViewById<TextView>(R.id.PreguntaTextView)
        var resp1 = findViewById<CardView>(R.id.Respuesta1)
        var tvResp1 = findViewById<TextView>(R.id.tvResp1)
        var resp2 = findViewById<CardView>(R.id.Respuesta2)
        var tvResp2 = findViewById<TextView>(R.id.tvResp2)
        var resp3 = findViewById<CardView>(R.id.Respuesta3)
        var tvResp3 = findViewById<TextView>(R.id.tvResp3)
        var resp4 = findViewById<CardView>(R.id.Respuesta4)
        var tvResp4 = findViewById<TextView>(R.id.tvResp4)
        var btnAceptar = findViewById<Button>(R.id.btnAceptar)
        var i = 0

        savedInstanceState?.let {
            num = it.getInt("num", 0)
            questionsList = it.getSerializable("questionsList") as? List<Kahoot> ?: emptyList()
        }

        lifecycleScope.launch {
            var questionsList = app.room.kahootDao().getKahoot()
            i = Random.nextInt(0, questionsList.size)
            pregunta.text = questionsList[i].pregunta
            tvResp1.text = questionsList[i].primera_respuesta
            tvResp2.text = questionsList[i].segunda_respuesta
            tvResp3.text = questionsList[i].tercera_respuesta
            tvResp4.text = questionsList[i].cuarta_respuesta
            var respuestaCorrecta = questionsList[i].respuesta_correcta

            var eleccion = ""
            resp1.setOnClickListener {
                resp1.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
                resp2.setCardBackgroundColor(Color.parseColor("#0004FF"))
                resp3.setCardBackgroundColor(Color.parseColor("#FF9900"))
                resp4.setCardBackgroundColor(Color.parseColor("#007805"))

                eleccion = "opcion1"
            }

            resp2.setOnClickListener {
                resp2.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
                resp1.setCardBackgroundColor(Color.parseColor("#FF0000"))
                resp3.setCardBackgroundColor(Color.parseColor("#FF9900"))
                resp4.setCardBackgroundColor(Color.parseColor("#007805"))

                eleccion = "opcion2"
            }

            resp3.setOnClickListener {
                resp3.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
                resp2.setCardBackgroundColor(Color.parseColor("#0004FF"))
                resp1.setCardBackgroundColor(Color.parseColor("#FF0000"))
                resp4.setCardBackgroundColor(Color.parseColor("#007805"))

                eleccion = "opcion3"
            }

            resp4.setOnClickListener {
                resp4.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
                resp2.setCardBackgroundColor(Color.parseColor("#0004FF"))
                resp3.setCardBackgroundColor(Color.parseColor("#FF9900"))
                resp1.setCardBackgroundColor(Color.parseColor("#FF0000"))

                eleccion = "opcion4"
            }

            btnAceptar.setOnClickListener{
                if(tvResp1.text.equals(respuestaCorrecta) && eleccion.equals("opcion1")){
                    Toast.makeText(this@JugarScreen, "CORRECTO", Toast.LENGTH_LONG).show()
                    questionsList.removeAt(i)
                    recreate()
                }
                else if(tvResp2.text.equals(respuestaCorrecta) && eleccion.equals("opcion2")){
                    Toast.makeText(this@JugarScreen, "CORRECTO", Toast.LENGTH_LONG).show()
                    questionsList.removeAt(i)
                    recreate()
                }
                else if(tvResp3.text.equals(respuestaCorrecta) && eleccion.equals("opcion3")){
                    Toast.makeText(this@JugarScreen, "CORRECTO", Toast.LENGTH_LONG).show()
                    questionsList.removeAt(i)
                    recreate()
                }
                else if(tvResp4.text.equals(respuestaCorrecta) && eleccion.equals("opcion4")){
                    Toast.makeText(this@JugarScreen, "CORRECTO", Toast.LENGTH_LONG).show()
                    questionsList.removeAt(i)
                    recreate()
                }
                else{
                    Toast.makeText(this@JugarScreen, "INCORRECTO", Toast.LENGTH_LONG).show()
                    questionsList.removeAt(i)
                    recreate()
                }

                num ++
                Log.e("valor", "$num")
                if (num == 5){
                    finish()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("num", num)
        outState.putSerializable("questionsList", ArrayList(questionsList))
        super.onSaveInstanceState(outState)
    }
}