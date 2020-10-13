package me.timur.docs.model

data class AddNewUserRequest(
        var username: String,
        var password: String,
        var email: String? = "",
        var phone: String? = "",
        var role: String = "USER"
)