package com.example.kotlin.ex4

import com.example.kotlin.ex1.Person

object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for( person in allEmployees ){
            person.age?.times(10)
        }
    }
}