package es.iesjandula.kahoot

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class JugarScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar_screen)

        var resp1 = findViewById<CardView>(R.id.Respuesta1)
        var resp2 = findViewById<CardView>(R.id.Respuesta2)
        var resp3 = findViewById<CardView>(R.id.Respuesta3)
        var resp4 = findViewById<CardView>(R.id.Respuesta4)

        resp1.setOnClickListener {
            resp1.setCardBackgroundColor(Color.DKGRAY)
            resp2.setCardBackgroundColor(Color.parseColor("@color/btn2"))
            resp3.setCardBackgroundColor(Color.parseColor("@color/btn3"))
            resp4.setCardBackgroundColor(Color.parseColor("@color/btn4"))
        }

        resp2.setOnClickListener {
            resp2.setCardBackgroundColor(Color.DKGRAY)
            resp1.setCardBackgroundColor(Color.parseColor("@color/btn1"))
            resp3.setCardBackgroundColor(Color.parseColor("@color/btn3"))
            resp4.setCardBackgroundColor(Color.parseColor("@color/btn4"))
        }

        resp3.setOnClickListener {
            resp3.setCardBackgroundColor(Color.DKGRAY)
            resp2.setCardBackgroundColor(Color.parseColor("@color/btn2"))
            resp1.setCardBackgroundColor(Color.parseColor("@color/btn1"))
            resp4.setCardBackgroundColor(Color.parseColor("@color/btn4"))
        }

        resp4.setOnClickListener {
            resp4.setCardBackgroundColor(Color.DKGRAY)
            resp2.setCardBackgroundColor(Color.parseColor("@color/btn2"))
            resp3.setCardBackgroundColor(Color.parseColor("@color/btn3"))
            resp1.setCardBackgroundColor(Color.parseColor("@color/btn1"))
        }
    }
}