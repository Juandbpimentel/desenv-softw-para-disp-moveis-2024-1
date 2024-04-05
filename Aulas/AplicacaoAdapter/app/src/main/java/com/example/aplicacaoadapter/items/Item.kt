package com.example.aplicacaoadapter.items

import android.graphics.drawable.Drawable

class Item(itemName: String,imageSrc:String,description:String) {
    private var name = itemName
    private var imageSrc:String = imageSrc
    private var description:String = description

    public fun getName(): String {
        return name
    }

    public fun setName(recievedName: String): Unit{
        this.name = recievedName
    }

    public fun getImageSrc(): String {
        return Drawable.createFromPath(imageSrc)
    }

    public fun setImageSrc(imageSrc: String): Unit{
        this.imageSrc = imageSrc
    }

    public fun getDescription(): String {
        return this.description
    }

    public fun setDescription(description: String): Unit{
        this.description
    }


}