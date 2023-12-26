package es.iesjandula.kahoot

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class JugarScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar_screen)

        var resp1 = findViewById<CardView>(R.id.Respuesta1)
        var resp2 = findViewById<CardView>(R.id.Respuesta2)
        var resp3 = findViewById<CardView>(R.id.Respuesta3)
        var resp4 = findViewById<CardView>(R.id.Respuesta4)

        resp1.setOnClickListener {
            resp1.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
            resp2.setCardBackgroundColor(Color.parseColor("#0004FF"))
            resp3.setCardBackgroundColor(Color.parseColor("#FF9900"))
            resp4.setCardBackgroundColor(Color.parseColor("#007805"))
        }

        resp2.setOnClickListener {
            resp2.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
            resp1.setCardBackgroundColor(Color.parseColor("#FF0000"))
            resp3.setCardBackgroundColor(Color.parseColor("#FF9900"))
            resp4.setCardBackgroundColor(Color.parseColor("#007805"))
        }

        resp3.setOnClickListener {
            resp3.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
            resp2.setCardBackgroundColor(Color.parseColor("#0004FF"))
            resp1.setCardBackgroundColor(Color.parseColor("#FF0000"))
            resp4.setCardBackgroundColor(Color.parseColor("#007805"))
        }

        resp4.setOnClickListener {
            resp4.setCardBackgroundColor(Color.parseColor("#FF03DAC5"))
            resp2.setCardBackgroundColor(Color.parseColor("#0004FF"))
            resp3.setCardBackgroundColor(Color.parseColor("#FF9900"))
            resp1.setCardBackgroundColor(Color.parseColor("#FF0000"))
        }
    }
}