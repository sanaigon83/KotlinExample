package com.example.kotlin.ex6


import java.io.BufferedReader
import java.lang.IllegalStateException
import java.lang.NumberFormatException
import java.util.concurrent.ConcurrentHashMap


class KotlinExample6 {
    interface Processor<T> {
        fun process() : T
    }

    fun example() = run {

        /**
         * null 인자를 받을 수 없는 함수라면 다음과 같이 작성할 수 있다.
         */
        fun strLen(s: String) = s.length
        //strLen(null) // 컴파일 에러가 난다.

        /**
         * Nullable은 null체크 후 사용할 수 있다.
         * 굳이 if문을 사용하지 않아도 되는 편의를 제공하는 다양한 함수가 별도로 있긴하다.
         */
        fun strLenSafe(s: String?): Int =
            if (s != null) s.length else 0


        /**
         * ?. 를 이용한 Nullable 한 변수의 사용 방법
         */
        fun strLenSafeBetter(s: String?): Int = s?.length ?: 0

        class Employee(val name: String, val manager: Employee?)

        fun managerName(employee: Employee): String? = employee.manager?.name

        /**
         * ?: 엘비스 연산자
         * null일 경우 default 값을 지정해줄 수 있는 연산자.
         */
        fun foo2(s: String?): String {
            return s ?: "Nothing"
        }

        /**
         * throw도 연산식에 해당하므로 ?: 연산자를 사용할 수 있다.
         */

        fun foo3(s: String?): String {
            //s ?: throw NullPointerException("null")
            // 책에서는 return 도 연산식에 해당하므로 ?: 연산자를 적용할 수 있다고 하나 실제론 안된다.
            // A 'return' expression required in a function with a block body ('{...}')
            s ?: return "Empty"
            return s
        }

        println(foo3(null))

        /**
         * 다음의 코드는 as? 연산자와 ?: 연산자의 혼합해서 사용하는 좋은 예를 보여준다
         */
        class PersonKoltin(val firstName: String, val lastName: String) {
            override fun equals(other: Any?): Boolean {
                val otherPerson = other as? PersonKoltin ?: return false
                return otherPerson.firstName == firstName && otherPerson.lastName == lastName
            }

            override fun hashCode(): Int {
                return super.hashCode() * 37 + lastName.hashCode()
            }
        }

        /**
         * null이 아닌 인자를 받는 함수에 nullable한 인자를 전달하는 방법은 let함수를 사용하는 것이다.
         * null이 아닐때에만 let 함수안에 동작이 수행될 것이다.
         */
        val email: String? = null
        fun sendEmailTo(email: String) { /*..*/
        }
        email?.let { sendEmailTo(it) }

        fun getTheBestPersonInTheWorld(): String? = null
        // 아래의 endEmailTo 메소드는 결코 호출되지 않는다
        getTheBestPersonInTheWorld()?.let { sendEmailTo(it) }

        fun <T: Any>printHashCode(t: T) {
            println(t?.hashCode()) // T는 null이 될 수 있으므로 safety call을 써야만 한다.
        }

        // 컴파일 에러가 발생함.
        // Null can not be a value of a non-null type TypeVariable(T)
        //printHashCode(null)

        fun yellAtSafe(person: Person) {
            println((person.name ?: "AnyOne").uppercase() + "!!!")
        }

        yellAtSafe(Person(null))

        val map = ConcurrentHashMap<Int, String>()

        fun showProgress(progress: Int) {
            val percent = progress.coerceIn(0, 100)
            println("We're ${percent}% done!")
        }

        val str = "test"

        val d: Object = str as java.lang.Object

        class NoResultProcessor : Processor<Nothing> {
            override fun process(): Nothing {
                TODO("Not yet implemented")
            }
        }

        val obj: Int? = 2

        fun nothingThrow(): Nothing = throw IllegalStateException()
        val address = obj ?: "Test"//nothingThrow()
        println(address)

        val ml: MutableList<Int> = mutableListOf(1,2,3,4)
        val il: List<Int> = ml

        val convertArray: Array<Int> = il.toTypedArray()
        val letters = Array(26) { i -> ('a' + i).toString() }

    }

    fun readNumbers(reader: BufferedReader): List<Int?> {
        val result = ArrayList<Int?>()
        for(line in reader.lineSequence()) {
            try{
                val number = line.toInt()
                result.add(number)
            }
            catch (e: NumberFormatException) {
                result.add(null)
            }
        }

        return result
    }



    fun addValidNumbers(numbers: List<Int?>) {
        val validList: List<Int> = numbers.filterNotNull()
        println("Sum of valid Numbers : ${validList.sum()}")
        println("Invalid numbers: ${numbers.size - validList.size}")
    }
}