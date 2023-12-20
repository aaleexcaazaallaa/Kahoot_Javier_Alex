package es.iesjandula.kahoot

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Kahoot::class],
    version = 1
)
abstract class KahootDb: RoomDatabase() {
    abstract fun kahootDao(): KahootDao
}