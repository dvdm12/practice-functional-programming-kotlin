package excercises

import kotlin.math.pow

// ---------- 4) Higher-Order Functions ----------

fun operate(a: Int, b: Int, f: (Int, Int) -> Int): Int = f(a, b)

fun powerOf(exp: Int): (Int) -> Int = { base -> base.toDouble().pow(exp).toInt() }

fun higherOrderDemo() {
    val sum = operate(5, 3) { x, y -> x + y }
    val product = operate(5, 3) { x, y -> x * y }
    val square = powerOf(2)
    val cube = powerOf(3)
    println("[HOF A] sum= $sum  product= $product")
    println("[HOF B] square(4)= ${square(4)}  cube(2)= ${cube(2)}")
}


fun buildPasswordValidator(rules: List<(String) -> Boolean>): (String) -> Boolean {
    return { password -> rules.all { rule -> rule(password) } }
}

fun higherOrderDemoC() {

    val minLength: (String) -> Boolean = { it.length >= 8 }
    val hasUpper: (String) -> Boolean = { it.any { c -> c.isUpperCase() } }
    val hasDigit: (String) -> Boolean = { it.any { c -> c.isDigit() } }

    val validator = buildPasswordValidator(listOf(minLength, hasUpper, hasDigit))

    // Trying different passports
    val passwords = listOf("short", "nouppercase1", "ValidPass1", "AnotherGood9")
    for (p in passwords) {
        println("Password '$p' valid? ${validator(p)}")
    }
}