package repository

import model.User

// In-memory repository for managing users
class UserRepo {
    private val storage = mutableMapOf<Int, User>()
    private var seq = 1

    // Create a new user
    fun create(u: User): User =
        u.apply {                         
            id = seq++
            if ("@" !in email) email = "$email@example.com"
            roles += "USER"
        }.also { created ->               
            println("[LOG] Creating user: ${created.name} -> id=${created.id}")
            storage[created.id!!] = created
        }

    // Get user by ID
    fun get(id: Int): User? = storage[id]

    // Deactivate a user if exists
    fun deactivate(id: Int): Boolean =
        storage[id]?.let { user ->     
            user.active = false
            true
        } ?: false

    fun listActive(): List<User> = storage.values.filter { it.active }
}
