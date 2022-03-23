package com.example.kotlin.ex5

import com.example.kotlin.ex1.Person
import java.io.File

/**
 *
 */
class KotlinExample5 {

    class Book(val title: String, val authors: List<String>)

    fun runExample() = run {
        val people = listOf(
            Person("Alice", 31),
            Person("Bob", 29),
            Person("Carol", 31)
        )

        val books = listOf(
            Book("자바의 정석", listOf("jkpark", "plantrue")),
            Book("자바의 정석2", listOf("jkpark")),
            Book("자바의 정석3", listOf("jkpark", "ydj3"))
        )

        /**
         * 지연 연산없이 직접 연산틍 통한 예
         * 다음의 연산은 호출여부와 상관없이 중간 연산이 이뤄진다.
         * 즉 중간 연산마다 중간 연산을 저장하는 별도의 Collection을 만들게 된다.
         */
        val ret =
            people.map { it.name }.filter { it.startsWith("A") }

        /**
         * 지연 연산을 이용한 예
         * 다음의 연산은 실제 호출이 될 때만 계산되어 최종 연산을 만들어 낸다.
         */
        val ret2 =
            people.asSequence().map { it.name }.filter { it.startsWith("A") }

        // 다음처러 실제 list를 만드는 순간 모든 연산이 이뤄진다.
        ret2.toList()

        /**
         * Sequence로 연산을 할 경우 연속되는 연산의 순서에 따라서 동작하는 형식도 많이 달라진다.
         * 아래의 코드는 모든 원소에 대하 name을 얻은 후 filter를 적용하여 만족한 리스트를 얻는다.
         */
        println(people.asSequence().map { it.name }.filter { it.length < 4 }.toList())

        /**
         * 하지만 아래의 코드는 모든 원소에 대하 filter를 먼저 적용하기 때문에 만족하는 원소들에 대해서만 map이 적용된다.
         */
        println(people.asSequence().filter { it.name.length < 4 }.map { it.name }.toList())
    }

    /**
     * 시퀀스 만들기
     * 0 부터 100까지 자연수의 합을 구하는 예제 
     */
    fun runExample2() = run {
        val naturalNumbers = generateSequence(0) { it + 1 }
        val numberTo100: Sequence<Int> = naturalNumbers.takeWhile { it <= 100 }
        println(numberTo100.sum()) // 이 부분에서 실제 연산이 이뤄진다.
    }

    /**
     * 시퀀스르 사용하는 일반적인 용례중 하나는 객체의 조상으로 이뤄진 시퀀스를 만들어 내는것
     * 모든 조상의 시퀀스에서 어떤 특성을 알고 싶을때 사용할 수 있다. 
     * 다음은 어떤 파일의 상위 디렉터리를 뒤지면서 숨김속성을 가진 디렉터리가 있는지 검사함으로써 파일이 감춰진 디렉터리 안에 들어있는지 알아본다. 
     */
    
    fun File.isInsideHiddenDirectory(): Boolean = 
        generateSequence(this) { it.parentFile }.any { it.isHidden }

    fun postponeComputation(delay: Long, computation: Runnable) {
        Thread.sleep(delay)
        computation.run()
    }

    fun runExample3() = run {
        postponeComputation(100) { println(43) }
    }

    fun createAllDoneRunnable(): Runnable {
        return Runnable { println("All Done") }
    }

    /**
     * result에 대해 다른 여러 메소드를 호출하면서 매번 result를 반복사용 하는 경우
     */
    fun alphabet(): String {
        val result = StringBuilder()
        for(letter in 'A'..'Z'){
            result.append(letter)
        }
        result.append("\nNow I Know the alphabet!")
        return result.toString()
    }

    val sampleLambda = { a: StringBuilder ->
        for( letter in 'A'..'Z'){
            a.append(letter)
        }
        a.append("\nNow I Know the alphabet!")
        this.toString()
    }
    /**
     * with를 사용하여 다음과 같이 다시 작성할 수 있다.
     */
    fun alphabetWith(): String {
        val stringBuilder = StringBuilder()
        return with(stringBuilder){
            sampleLambda(this)
        }
    }

    fun alphabe() = with(StringBuilder()){
        for( letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I Know the alphabet!")
        this.toString()
    }

    fun alphabetWithApply() = StringBuilder().apply {
        for( letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I Know the alphabet!")
    }.toString()

    fun createMZPerson(name: String) =
        Person(name, 33).apply {
            newAge = 32
        }

    fun verySimpleAlphabet() = buildString{
        for( letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I Know the alphabet!")
    }
}

