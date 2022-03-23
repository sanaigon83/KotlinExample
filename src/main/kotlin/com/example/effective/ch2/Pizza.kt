package com.example.effective.ch2

import java.util.*

abstract class Pizza(builder: Builder<*>) {
    val toppings: Set<Topping> = builder.toppings.clone()

    enum class Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

    abstract class Builder<T : Builder<T>> {
        val toppings: EnumSet<Topping> = EnumSet.noneOf(Topping::class.java)

        fun addTopping(topping: Topping): T {
            toppings.add(topping)
            return self()
        }

        abstract fun build(): Pizza

        protected abstract fun self(): T
    }
}