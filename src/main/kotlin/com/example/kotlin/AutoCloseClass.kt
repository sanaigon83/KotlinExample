package com.example.kotlin

import java.io.Closeable
import java.io.File

class AutoCloseClass() : Closeable {
    override fun close() {
        println("AutoCloseClass is close")
    }
}