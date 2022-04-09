package com.example.kotlin.ex7

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class KotlinExample7 {
    data class Point(val x: Int, val y: Int) {
        /**
         * 산술 연산자 오버로딩
         */

        // 연산자를 오버로딩 하기 위해서는 operator가 붙어야 한다.
        // operator가 붙어야 plus를 + 연산자로 인식 할 수 있다.
        operator fun plus(other: Point): Point {
            println("${(2 or 2).inv()}")
            return Point(other.x + x, other.y + y)
        }
    }

    /**
     * 다음과 같이 선언해도 위의 member function 으로 선언한 것과 동일한 효과를 낼 수 있다.
     */
    operator fun Point.plus(other: Point): Point {
        println("call extension function")
        return Point(x + other.x, y + other.y)
    }

    class MyDelegate() {
        operator fun getValue(foo: Foo, property: KProperty<*>): Int {
            println("call getValue")
            return 10
        }

        operator fun setValue(foo: Foo, property: KProperty<*>, i: Int) {
            println("call SetValue")
            println(property.name)
        }

    }
    /** delegated property example*/
    class Foo {
        var p: Int by MyDelegate()
        val p1: Int by lazy {
            1
        }
    }

    class Person {
        // 추가정보
        private val _attribute = hashMapOf<String, String>()

        fun setAttribute(attrName: String, value: String) {
            _attribute[attrName] = value
        }

        //필수 정보
        val name: String by _attribute
    }

    fun example() = run {
        val p = Person()
        val data = mapOf("name" to "Dmitiy", "company" to "JetBrain")

        data.forEach { k, v ->
            p.setAttribute(k, v)
            }

        println(p.name)
    }
}
