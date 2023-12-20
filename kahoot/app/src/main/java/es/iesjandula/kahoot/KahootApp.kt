package es.iesjandula.kahoot

import android.app.Application
import androidx.room.Room

class KahootApp: Application() {

    companion object{
        lateinit var room: KahootDb
    }

    override fun onCreate() {
        super.onCreate()
        room = Room.databaseBuilder(applicationContext, KahootDb::class.java, "kahoot").fallbackToDestructiveMigration().build()
    }
}