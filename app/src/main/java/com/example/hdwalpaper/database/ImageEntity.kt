package com.example.hdwalpaper.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class ImageEntity:Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
    var name:String?=null
    var image:String?=null
    var isCheck:Boolean?=null
    var image1:Int?=null

    constructor(name: String?, image: String?, isCheck: Boolean?, image1: Int?) {
        this.name = name
        this.image = image
        this.isCheck = isCheck
        this.image1 = image1
    }
}