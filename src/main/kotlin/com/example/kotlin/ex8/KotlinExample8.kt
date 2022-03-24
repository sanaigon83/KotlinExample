package com.example.kotlin.ex8

enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

class KotlinExample8 {

    fun getShippingCostCal(delivery: Delivery): (Order) -> Double {
        if (delivery == Delivery.STANDARD) {
            return { order -> 6 + 2.1 * order.itemCount }
        }
        return { order -> 1.2 * order.itemCount }
    }


    fun example() = run {

        val log: List<SiteVisit> = listOf(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOWS),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.0, OS.ANDROID),
        )

        val average =
            log.filter { it.os == OS.WINDOWS }
                .map(SiteVisit::duration)
                .average()


        fun List<SiteVisit>.averageDurationFor(os: OS) =
            filter { it.os == os }
                .map(SiteVisit::duration)
                .average()

        println(log.averageDurationFor(OS.WINDOWS))

        /**
         * 8.2.3 컬렉션 연산 인라이닝
         */
        data class Person(val name: String, val age: Int)

        val people = listOf(Person("Alice", 24), Person("Bob", 31))

        //람다를 이용한 거르기
        println(people.filter { it.age < 30 })

        // 컬렉션 직접 거르기
        val result = mutableListOf<Person>()
        for (person in people) {
            if (person.age < 30) result.add(person)
        }
        println(result)

        //다음은 filter와 map을 연쇄적으로 사용하는 경우이다.
        people.filter { it.age < 30 }
            .map(Person::name)

        /**
         * 위의 코드중 filter와 map에 들어가는 코드는 inlining 된다.
         * 하지만 중간 결과를 저장하기 위한 중간 리스트를 만들어낸다.
         * 리스트의 크기가 커지게 되는 경우 이는 부하를 줄 수 있다.
         * 이 때 이를 방지하고자 asSequence를 통해 리스트 대신 시퀀스를 사용하면 중간 리스트로 인한 부가비용은 줄어든다.
         * 이 중간 시퀀스는 람다를 필드에 저장하는 객체로 표현되며, 최종 연산은 중간 시퀀스에 있는 여러 람다를 연쇄 호출한다.
         * 따라서 asSequence를 붙이게 되면 람다는 인라이닝 되지 않으므로 모든 컬렉션 연산에 asSequence를 붙여선 안된다.
         */
        people.asSequence().filter { it.age < 30 }.map(Person::name).forEach { println(it) }
    }


    inline fun inlineExample(fn: (Int) -> Int): Int = fn(2)
}