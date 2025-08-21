package excercises

// ---------- 2) Pure Functions ----------

fun celsiusToFahrenheit(c: Double): Double = c * 9 / 5 + 32

fun applyDiscount(price: Double, percent: Double): Double =
    price - (price * percent / 100)

fun pureFunctionsDemo() {
    val f = celsiusToFahrenheit(25.0)
    val discounted = applyDiscount(100.0, 15.0)
    println("[Pure A] 25°C -> $f°F")
    println("[Pure B] price=100.0, 15% -> $discounted")
}
