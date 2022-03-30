package com.example.kotlin.ex7

import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 아래의 예제는 위임자 프로퍼티의 사용예를 보여준다.
 *
 * Property의 변경시마다 event 알람을 받도롣 처리한 내용이다.
 */
/*
class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}
*/

class ObservableProperty(
    var propValue: Int,
    val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(person: Person, property: KProperty<*>): Int = propValue

    operator fun setValue(person: Person, property: KProperty<*>, i: Int) {
        val oldValue = propValue
        propValue = i
        changeSupport.firePropertyChange(property.name, oldValue, i)
    }

}

/*
class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}
*/

/**
 * 다음은 이미 ObservableProperty와 같은 역할을 하는 클래스를 이용한 코드이다.
 */

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    // 람다로 observer를 선언
    private val observer: (KProperty<*>, Int, Int) -> Unit = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}