package com.example.kotlin.ex7

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener

class KotlinExample7 {
    fun example() = run {
        val p = Person("Dmitry", 34, 2000)
        p.addListener(
            PropertyChangeListener { event: PropertyChangeEvent ->
                println("Property ${event.propertyName} changed" + "from ${event.oldValue} to ${event.newValue}")
            }
        )

        p.age = 35
        p.salary = 2100
    }
}