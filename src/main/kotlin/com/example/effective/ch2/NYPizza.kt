package com.example.effective.ch2

class NyPizza (builder: Builder) : Pizza(builder) {
    enum class Size { SMALL, MEDIUM, LARGE }
    var size: Size? = null

    class Builder(val size: Size) : Pizza.Builder<Builder>(){
        override fun build(): NyPizza {
            return NyPizza(this)
        }
        override fun self(): Builder {
            return this
        }
    }
}