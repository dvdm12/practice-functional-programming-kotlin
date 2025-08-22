package model

// Basic user model
data class User(
    var id: Int? = null,                 
    var name: String,
    var email: String,
    var active: Boolean = true,
    val roles: MutableList<String> = mutableListOf()
)


