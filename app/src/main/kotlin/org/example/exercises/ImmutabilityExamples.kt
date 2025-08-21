package excercises

data class Account(val id: Int, val balance: Double)

// ---------- 1) Immutability ----------

fun immutabilityExampleA() {
    val a1 = Account(1, 100.0)
    val a2 = a1.copy(balance = a1.balance + 50)
    println("[Immutability A] original=$a1  updated=$a2")
}

fun immutabilityExampleB() {
    val numbers = listOf(1, 2, 3)
    val newNumbers = numbers + 4
    println("[Immutability B] numbers=$numbers  newNumbers=$newNumbers")
}
