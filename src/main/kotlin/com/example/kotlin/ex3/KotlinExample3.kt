package com.example.kotlin.ex3
import com.example.kotlin.ex3.strings.join
import com.example.kotlin.ex3.strings.opCount
import java.lang.StringBuilder

class KotlinExample3 {
    fun example() = run {


        val list = listOf(1,2,3)

        println(listOf(1,2,3).join("; ", "(", ")"))

        opCount += 1

        fun testFunc(args: Array<String>) {
            val list = listOf("args:", *args)
            println(list)
        }

        val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        "test" add "test2"
    }

    fun getReport(reportId: Long, vararg value: Int) {
        println(reportId)
        println(value)
    }

    //중위함수 호출 예제
    infix fun String.add(str: String): String = this + str
}