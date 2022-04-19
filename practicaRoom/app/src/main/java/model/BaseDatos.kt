package model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import model.dao.ClasificacionDao
import model.entities.ClasificacionEntity

interface MainDataBaseProvider{
    fun clasificacionDao(): ClasificacionDao
}

@Database (entities = [ClasificacionEntity::class],
    version = 1
)
abstract class MainDataBase: RoomDatabase(), MainDataBaseProvider {
    abstract override fun clasificacionDao(): ClasificacionDao
    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun getInstance(context: Context):MainDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}