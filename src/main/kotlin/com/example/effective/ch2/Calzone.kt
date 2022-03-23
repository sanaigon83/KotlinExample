package com.example.effective.ch2

class Calzone(builder: Builder) : Pizza(builder) {
    val sauceInside = builder.sauceInside

    class Builder : Pizza.Builder<Builder>() {
        var sauceInside: Boolean = false
        override fun build(): Calzone {
            return Calzone(this)
        }

        fun sauceInside(): Builder {
            sauceInside = true
            return this
        }

        override fun self(): Builder {
            return this
        }
    }

    override fun toString(): String {
        return "Calzone(sauceInside=$sauceInside, toppings=${this.toppings})"
    }
}