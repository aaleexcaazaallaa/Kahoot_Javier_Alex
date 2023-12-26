package es.iesjandula.kahoot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //mostrar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones_kahoot, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Damos funcionalidad a las opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ConfiguracionPreguntas -> {
                val intentCofigurarPregs = Intent(this, ConfiguracionPreguntas::class.java)
                startActivity(intentCofigurarPregs)
            }
            R.id.Jugar -> {
                val intentJugar = Intent(this, JugarScreen::class.java)
                startActivity(intentJugar)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}