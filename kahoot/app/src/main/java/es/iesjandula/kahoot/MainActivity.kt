package es.iesjandula.kahoot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val app = KahootApp
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
                lifecycleScope.launch {
                    var questionsList = app.room.kahootDao().getKahoot()
                    if (questionsList.size < 5){
                        Toast.makeText(this@MainActivity, "No hay suficientes preguntas", Toast.LENGTH_LONG).show()
                    }
                    else{
                        val intentJugar = Intent(this@MainActivity, JugarScreen::class.java)
                        startActivity(intentJugar)
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}