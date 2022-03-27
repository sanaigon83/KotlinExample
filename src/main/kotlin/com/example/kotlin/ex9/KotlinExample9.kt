package com.example.kotlin.ex9

import java.lang.Appendable

class KotlinExample9 {
    fun example() = run {
        val lazyValue: String by lazy {
            println("computed")
            "Hello"
        }

        println(lazyValue)
        println(lazyValue)

        class newAppend(override val length: Int = 2) : Appendable, CharSequence {
            override fun append(csq: CharSequence?): Appendable {
                TODO("Not yet implemented")
            }

            override fun append(csq: CharSequence?, start: Int, end: Int): Appendable {
                TODO("Not yet implemented")
            }

            override fun append(c: Char): Appendable {
                TODO("Not yet implemented")
            }

            override fun get(index: Int): Char {
                TODO("Not yet implemented")
            }

            override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
                TODO("Not yet implemented")
            }
        }

        val obj = newAppend()

        ensureTrailingPeriod(obj)
    }

    fun <T : Comparable<T>> max(first: T, second: T): T {
        return if (first > second) first else second
    }

    fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T: Appendable {
            if(!seq.endsWith('.')) {
                seq.append('.')
            }
    }
}