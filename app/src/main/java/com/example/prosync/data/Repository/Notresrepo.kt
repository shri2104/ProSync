package com.example.prosync.data.Repository

import com.example.prosync.Domain.Model.Note
import kotlinx.coroutines.flow.Flow

interface Notresrepo{
    fun getnotes(): Flow<List<Note>>
    suspend fun addNote(note: Note)
}