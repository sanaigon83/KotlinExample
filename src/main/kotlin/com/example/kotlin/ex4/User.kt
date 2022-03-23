package com.example.kotlin.ex4

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.Serializable

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}
/*
class Person2(val name: String) {

    companion object : JSONFactory<Person>{
        override fun fromJSON(jsonText: String): Person {
            return Person("test")
        }
    }


}

fun Person.Companion.fromJSON2(json: String): Person {
    return Person("test")
}

fun countClicks(window: Window) {
    var clickCount = 0

    window.addMouseListener(object : MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            /**
             * object를 식처럼 표현할 수 있고
             * 그 식을 포함하고 있는 함수의 맴버에 접근할 수 있다.
             * 자바는 final로 선언된 변수만 접근할 수 있지만 kotlin의 경우 final이 아니더라도
             * 객체의 식 안에서 사용할 수 있따.
             */
            clickCount++
        }
    })
}
*/
