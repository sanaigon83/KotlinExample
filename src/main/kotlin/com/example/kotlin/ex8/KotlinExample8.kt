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
    }


    inline fun inlineExample(fn: (Int) -> Int): Int = fn(2)
}