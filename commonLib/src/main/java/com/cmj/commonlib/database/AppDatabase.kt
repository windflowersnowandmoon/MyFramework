package com.cmj.commonlib.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Menses::class , User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mensesdDao() : Menses

//    abstract fun

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user.db" //数据库名称
                ).allowMainThreadQueries().build()
            }
            return instance as AppDatabase
        }
    }
}