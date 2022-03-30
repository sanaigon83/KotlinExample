package com.example.kotlin.ex9

import java.lang.Appendable
import java.util.*

/**
 * 다음은 공변성을 나타내는 out 키워드를 통해 명시적으로 들어내는 예 이다.
 */
interface Producer<out T> {
    fun produce(): T
}


class KotlinExample9 {
    fun example() = run {
        val lazyValue: String by lazy {
            println("computed")
            "Hello"
        }

        println(lazyValue)
        println(lazyValue)

        val value = listOf(1, 2, 3, 4)
        val ret =
            if (value is List<*>) {
                value.get(0)
            } else if (value is Map<*, *>) {
                value[0]
            }else
                0

        /**
         * 실체화한 타입 파라미터를 이용하는 예
         */
        val items = listOf("One", 2, "Three")
        println(items.filterIsInstance<String>())

        /**
        public inline fun <reified R> Iterable<*>.filterIsInstance(): List<@kotlin.internal.NoInfer R> {
            return filterIsInstanceTo(ArrayList<R>())
        }
         */

        /**
         * 다음은 변성에 관련한 예이다.
         */

        fun addAnswer(list: MutableList<Any>) = list.add(42)

        val strings = mutableListOf<String>("abc", "bac")

        // 아래의 코드는 컴파일 오류를 발생시킨다. MutalbeList<Any>에 MutableList<String>을 전달할 수 없다.
        //addAnswer(strings)

        //enumerateCats(Animal::getIndex)
    }

    inline fun <reified T> loadService(): ServiceLoader<T> = ServiceLoader.load(T::class.java)
    

    fun <T : Comparable<T>> max(first: T, second: T): T {
        return if (first > second) first else second
    }

    fun <T> ensureTrailingPeriod(seq: T)
            where T : CharSequence, T : Appendable {
        if (!seq.endsWith('.')) {
            seq.append('.')
        }
    }

    fun printSum(c: Collection<Int>) {
        /*
        val intList = c as? List<Int>
            ?: throw java.lang.IllegalArgumentException("List is expected")
        println(intList.sum())
         */

        if(c is List<Int>) {
            println(c.sum())
        }
    }

    //fun <T> isA2(value: Any) = value is T
    inline fun <reified T> isA(value: Any) = value is T


}