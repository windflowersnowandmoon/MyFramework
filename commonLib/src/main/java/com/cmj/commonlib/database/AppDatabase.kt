package com.cmj.commonlib.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Menses::class , User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMensesdDao() : MensesDao

    abstract fun getUserDao() : UserDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    if (instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "cmj.db" //数据库名称
                        ).allowMainThreadQueries().build()
                    }
                }

            }
            return instance as AppDatabase
        }
    }
}