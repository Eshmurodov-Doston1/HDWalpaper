package com.example.hdwalpaper.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageEntity::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun imageDao():ImageDao
    companion object{
        private var instanse:AppDatabase?=null
        @Synchronized
        fun getInstence(context: Context):AppDatabase{
            if (instanse==null){
                instanse = Room.databaseBuilder(context,AppDatabase::class.java,"image.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instanse!!
        }
    }
}