package com.example.aplicacaoadapter.items

import android.graphics.drawable.Drawable

class Item(private var name: String, private var image: Drawable, private var description: String) {

    public fun getName(): String {
        return name
    }

    public fun setName(recievedName: String): Unit{
        this.name = recievedName
    }

    public fun getImage(): Drawable {
        return image
    }

    public fun setImageSrc(image: Drawable): Unit{
        this.image = image
    }

    public fun getDescription(): String {
        return this.description
    }

    public fun setDescription(description: String): Unit{
        this.description
    }


}