package excercises

// ---------- 3) Lambda Expressions ----------

fun lambdaExampleA() {
    val numbers = listOf(1, 2, 3, 4)
    val squares = numbers.map { it * it }
    println("lambda A: numbers=$numbers  squares=$squares")
}

fun lambdaExampleB() {
    val greet: (String) -> String = { name -> "Hello, $name!" }
    println("lambda B: " + greet("Alice"))
}


data class Product(val name: String, val price: Double, val inStock: Boolean)

fun lambdaExampleC() {
    val products = listOf(
        Product("Laptop", 1200.0, true),
        Product("Mouse", 25.0, false),
        Product("Keyboard", 45.0, true),
        Product("Monitor", 300.0, true)
    )

    // apply discount
    val applyDiscount: (Product) -> Product = { p ->
        if (p.inStock) p.copy(price = p.price * 0.9) else p
    }

    val format: (Product) -> String = { p -> "${p.name} - $${"%.2f".format(p.price)}" }

    val discounted = products
        .filter { it.inStock }     
        .map(applyDiscount)        
        .sortedBy { it.price }     
        .map(format)               

    println("lambda C: discounted products = $discounted")
}