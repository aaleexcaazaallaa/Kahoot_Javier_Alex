package es.iesjandula.kahoot

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Kahoot")
data class Kahoot(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_numPregunta") var id_numPregunta: Long=0,
    @ColumnInfo(name = "pregunta") val pregunta: String,
    @ColumnInfo(name = "primera_respuesta") val primera_respuesta: String,
    @ColumnInfo(name = "segunda_respuesta") val segunda_respuesta: String,
    @ColumnInfo(name = "tercera_respuesta") val tercera_respuesta: String,
    @ColumnInfo(name = "cuarta_respuesta") val cuarta_respuesta: String,
    @ColumnInfo(name = "respuesta_correcta") val respuesta_correcta: String
)