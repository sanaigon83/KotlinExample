package com.example.kotlin.ex9

class Herd<out T : Animal> {
    private var herdList: List<T> = listOf<T>()
    val size: Int by lazy { 23 }
    operator fun get(i: Int): T = herdList.get(i)

    private fun dataConsume(data: T): Unit = println(data)
}

// 특정무리에 먹이를 전체 주는 함수
fun feedAll(animal: Herd<Animal>) {
    for( i in 0 until animal.size){
        animal[i].feed()
    }
}

/**
 * 고양이 객체 선언
 */
class Cat: Animal() {
    fun cleanLitter() { println("call cleanLitter") }
}

/**
 * 모든 고양이의 사육장을 청소하고 먹이를 주는 함수를 선언
 * 하지만, Herd class 내의 type이 공변적이지 않기 때문에 이 함수는 컴파일 실패함.
 */
fun takeCareOfCats(cats: Herd<Cat>) {
    for(i in 0 until cats.size) {
        cats[i].cleanLitter()
        feedAll(cats)
    }
}
/*
fun enumerateCats(f: (Cat) -> Number ) { ... }
fun Animal.getIndex(): Int = ...
*/
