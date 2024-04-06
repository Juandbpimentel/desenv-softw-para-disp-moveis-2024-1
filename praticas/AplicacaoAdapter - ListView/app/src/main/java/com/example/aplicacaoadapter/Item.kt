package com.example.aplicacaoadapter

import android.graphics.drawable.Drawable
import java.io.Serializable

class Item(private var name:String, private var description:String, private var image:Drawable) {
    private var imageId:Int = 0
    constructor(name:String, description: String,image: Drawable, imageId:Int):this(name, description, image){
        this.imageId = imageId
    }

    fun getName():String{
        return name
    }

    fun getDescription():String{
        return description
    }

    fun getImage():Drawable{
        return image
    }

    fun setName(name:String){
        this.name = name
    }

    fun setDescription(description:String){
        this.description = description
    }

    fun setImage(image:Drawable){
        this.image = image
    }

    fun setImageId(imageId:Int){
        this.imageId = imageId
    }

    fun getImageId():Int{
        return imageId
    }
}