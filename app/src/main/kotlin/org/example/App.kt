import repository.UserRepo
import model.User


// Demonstration of all five scope functions in a coherent flow
fun scopeFunctionsUserManagementDemo() {
    val repo = UserRepo()

    // RUN: initialization block that returns a computed value
    val admin = run {
        val base = User(name = "Ana", email = "ana@acme.io")
        base.roles += "ADMIN"
        base // last expression is the return value of run
    }

    repo.create(admin)                    // apply + also are used inside create()

    // APPLY: build and configure another user in a chain
    val editor = User(name = "Ben", email = "ben")
        .apply {
            roles += "EDITOR"
        }
    repo.create(editor)

    // WITH: operate on a collection without chaining
    val activeUsers = repo.listActive()
    with(activeUsers) {                   // WITH: receiver is "activeUsers"
        println("Active users: $size")
        forEach { println(" - ${it.name} [${it.roles.joinToString()}]") }
    }

    // ALSO: side-effect logging without breaking the chain
    val anaId = repo.listActive()
        .first { it.name == "Ana" }
        .also { println("[LOG] About to deactivate: ${it.name}") }
        .id!!

    // LET: handle nullable safely and transform to another type
    val ok = anaId.let { repo.deactivate(it) }
    println("Ana deactivation successful: $ok")

    // RUN: final summary in an isolated scope
    val summary = run {
        val remaining = repo.listActive()
        val names = remaining.joinToString { it.name }
        "Summary → active=${remaining.size} :: [$names]"
    }
    println(summary)
}

// If you want to test directly
fun main() = scopeFunctionsUserManagementDemo()
