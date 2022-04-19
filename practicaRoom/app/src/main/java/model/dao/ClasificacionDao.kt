package model.dao

import androidx.room.*
import model.entities.ClasificacionEntity

@Dao
interface ClasificacionDao {

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(clasificacion: ClasificacionEntity)

        @Query("SELECT * FROM Clasificacion")
        suspend fun getAll(): List<ClasificacionEntity>

        @Query("SELECT * FROM Clasificacion where idClasificacion= :id")
        suspend fun getByIdClasificacion(id: Int): ClasificacionEntity

        @Update
        fun update(clasificacion: ClasificacionEntity)

        @Delete
        fun delete(clasificacion: ClasificacionEntity)
}
