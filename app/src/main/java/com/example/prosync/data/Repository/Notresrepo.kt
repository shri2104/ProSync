package com.example.prosync.data.Repository

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.example.prosync.data.Local.NoteDao
import com.example.prosync.model.Note
import com.example.prosync.model.toDomain
import com.example.prosync.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.collections.listOf

interface NotesRepository{
    fun getnotes(): Flow<List<Note>>
    suspend fun addNote(note: Note)
}


class NotesrepoImpl @Inject constructor(
    private val notesdao: NoteDao
): NotesRepository{
    override fun getnotes(): Flow<List<Note>> =
        notesdao.getnotes().map { it.map { it.toDomain() } }
    override suspend fun addNote(note:Note){
        notesdao.addnotes(note.toEntity())
    }
}