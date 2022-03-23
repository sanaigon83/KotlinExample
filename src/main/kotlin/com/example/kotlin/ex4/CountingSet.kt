package com.example.kotlin.ex4

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet{
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

/**
 * val cset = CountringSet<Int>()
 *
 * cset.addAll(listOf(1,1,2))
 *
 * println("${cset.objectsAdded} objects were added, ${cset.size} remain")
 * => 3 objects were added, 2 remain
 *
 * add, addAll을 오버라이드 해서 카운터를 증가시키도 나머지는 내부 컨테이너(innerSet)에세 위임한다.
 */

