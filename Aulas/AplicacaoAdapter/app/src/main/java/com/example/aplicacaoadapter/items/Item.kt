package com.example.aplicacaoadapter.items

class Item(itemName: String) {
    private var name = itemName

    public fun getName(): String {
        return name
    }

    public fun setName(recievedName: String): Unit{
        name = recievedName
    }
}