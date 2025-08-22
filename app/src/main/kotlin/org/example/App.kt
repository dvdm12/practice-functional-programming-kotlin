package org.example

import java.util.Scanner
import repository.UserRepo
import service.UserService

/**
 * Console interactive application to demonstrate UserService
 * with scope functions (apply, let, also, with, run).
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val service = UserService(UserRepo())

    // Seed initial users (admin and editor)
    service.seedInitialUsers()

    while (true) {
        println(
            """
            
            === User Management Console ===
            1) Create user
            2) List active users
            3) Deactivate user by ID
            4) Show summary
            0) Exit
            -------------------------------
            Choose an option: 
            """.trimIndent()
        )

        when (scanner.nextLine().trim()) {
            "1" -> {
                print("Name : ")
                val name = scanner.nextLine().trim()

                print("Email: ")
                val email = scanner.nextLine().trim()

                print("Roles (comma separated, optional): ")
                val roles = scanner.nextLine().trim().ifBlank { null }

                val created = service.createUser(name, email, roles)
                println("Created: id=${created.id}, name=${created.name}, roles=${created.roles.joinToString()}")
            }

            "2" -> {
                val active = service.listActiveUsers()
                // WITH: operate on the collection for pretty printing
                with(active) {
                    if (isEmpty()) println("No active users.")
                    else {
                        println("Active users ($size):")
                        forEach { println(" - id=${it.id} :: ${it.name} [${it.roles.joinToString()}]") }
                    }
                }
            }

            "3" -> {
                print("Enter ID to deactivate: ")
                val ok = service.deactivateById(scanner.nextLine().trim())
                println(if (ok) "User deactivated successfully." else "Deactivation failed (invalid or not found).")
            }

            "4" -> println(service.summary())

            "0" -> {
                println("Exiting... Goodbye!")
                return
            }

            else -> println("Invalid option, please try again.")
        }
    }
}
