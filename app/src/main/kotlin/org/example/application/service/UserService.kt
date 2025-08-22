package service

import model.User
import repository.UserRepo

/**
 * Business layer. Does not handle console I/O.
 * Keeps the usage of scope functions where they improve readability.
 */
class UserService(private val repo: UserRepo) {

    fun seedInitialUsers() {
        // RUN: initialization block that returns the prepared admin user
        val admin = run {
            val base = User(name = "Ana", email = "ana@acme.io")
            base.roles += "ADMIN"
            base
        }
        repo.create(admin)

        // APPLY: configure another user in a chain
        val editor = User(name = "Ben", email = "ben").apply { roles += "EDITOR" }
        repo.create(editor)
    }

    fun createUser(name: String, email: String, rolesCsv: String?): User {
        // APPLY to configure; ALSO for a small business log
        val user = User(name = name, email = email).apply {
            roles += rolesCsv?.split(",")
                ?.map { it.trim() }
                ?.filter { it.isNotEmpty() }
                .orEmpty()
            if (roles.isEmpty()) roles += "USER"
        }.also {
            println("[SERVICE] creating ${it.name} with roles=${it.roles.joinToString()}")
        }
        return repo.create(user)
    }

    fun listActiveUsers(): List<User> = repo.listActive()

    fun deactivateById(idStr: String): Boolean {
        // LET to parse and transform into Boolean; RUN for early error message
        return idStr.toIntOrNull()?.let { id ->
            repo.get(id)?.also { println("[SERVICE] deactivating ${it.name} (id=$id)") }
            repo.deactivate(id)
        } ?: run {
            println("[SERVICE] invalid id: '$idStr'")
            false
        }
    }

    fun summary(): String = run {
        val active = repo.listActive()
        val names = if (active.isEmpty()) "(none)" else active.joinToString { it.name }
        "Summary → active=${active.size} :: $names"
    }
}
