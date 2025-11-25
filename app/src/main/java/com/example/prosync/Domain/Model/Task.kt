package com.example.prosync.Domain.Model

data class Task(
    val id: Int = 0,
    val title: String,
    val description: String? = null,
    val deadline: Long? = null,
    val reminderTime: Long? = null,
    val isCompleted: Boolean = false,
    val updatedAt: Long = System.currentTimeMillis(),
    val isSynced: Boolean = false
)
