package es.iesjandula.kahoot

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface KahootDao {

    @Query("Select * From Kahoot")
    suspend fun getKahoot(): MutableList<Kahoot>

    @Update
    suspend fun updateKahoot(kahoot: Kahoot)

    @Insert
    suspend fun insertKahoot(kahoot: List<Kahoot>)

    @Delete
    suspend fun deleteKahoot(kahoot: Kahoot)

}