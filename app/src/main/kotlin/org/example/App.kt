import excercises.*  
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n=== Functional Programming in Kotlin — Menu ===")
        println("1. Immutability examples")
        println("2. Pure functions example")
        println("3. Lambda expressions examples")
        println("4. Higher-order functions examples")
        println("5. Lazy evaluation demo")
        println("0. Exit")
        print("Choose an option: ")

        when (scanner.nextLine().trim()) {
            "1" -> {
                immutabilityExampleA()
                immutabilityExampleB()
            }
            "2" -> {
                pureFunctionsDemo()
            }
            "3" -> {
                lambdaExampleA()
                lambdaExampleB()
                lambdaExampleC()
            }
            "4" -> {
                higherOrderDemo()
                higherOrderDemoC()
            }
            "5" -> {
                println("-- Lazy config demo --")
                val r1 = fetchData("/users")
                val r2 = fetchData("/products")
                println(r1)
                println(r2)
            }
            "0" -> {
                println("Exiting... Goodbye!")
                return
            }
            else -> println("Invalid option, please try again.")
        }
    }
}
