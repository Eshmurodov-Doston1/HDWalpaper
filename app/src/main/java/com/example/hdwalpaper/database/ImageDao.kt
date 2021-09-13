package com.example.hdwalpaper.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ImageDao {
    @Insert
    fun insertImage(imageEntity: ImageEntity)

    @Update
    fun updateImage(imageEntity: ImageEntity)

    @Query("select*from imageentity where image1=:icon")
    fun getAllImage(icon:Int):LiveData<List<ImageEntity>>

    @Query("select*from imageentity where name=:name")
    fun getImage(name:String):ImageEntity
}