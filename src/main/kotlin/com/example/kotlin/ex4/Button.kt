package com.example.kotlin.ex4

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I'm ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm clickable!")
}

class Button : Clickable, Focusable{
    override fun click() {
        TODO("Not yet implemented")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

}