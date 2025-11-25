package com.example.prosync.Domain.Model


data class User(
    val email: String,
    val name: String = "",
    val token: String = ""
)

