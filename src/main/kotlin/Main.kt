import com.example.effective.ch2.Calzone
import com.example.effective.ch2.Pizza
import com.example.kotlin.AutoCloseClass
import com.example.kotlin.ex1.Person
import com.example.kotlin.ex3.KotlinExample3
import com.example.kotlin.ex4.*
import com.example.kotlin.ex5.KotlinExample5
import com.example.kotlin.ex6.KotlinExample6
import com.example.kotlin.ex7.KotlinExample7
import com.example.kotlin.ex8.KotlinExample8
import com.example.kotlin.ex9.KotlinExample9
//import com.example.kotlin.ex1.Person
import java.io.File

fun main() {
    /*
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // Kotlin의 람다 선언
    val lamda = { x: Int, y: Int -> x + y }

    //people.maxByOrNull (Person::age)
    run { println(42) }

    println(people.joinToString(" ") { it.name })

    fun printProblemCounts(response: Collection<String>) {
        var clientErrors = 0
        var serverErrors = 0
        response.forEach {
            if( it.startsWith("4")) {
                clientErrors++  // 람다 안에서 람다 밖의 변수를 변경한다.
            }
            else if(it.startsWith("5")){
                serverErrors++ // 람다 안에서 람다 밖의 변수를 변경한다.
            }
        }

        println("$clientErrors client errors, $serverErrors server errors")
    }

    val o = listOf(1,2,3,4)
    */

    val obj = KotlinExample7()
    obj.example()
}


