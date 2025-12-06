package com.example.prosync.Domain.usecase

import com.example.prosync.data.Repository.NotesRepository
import com.example.prosync.model.Note
import javax.inject.Inject

class addnote @Inject constructor(
    private val repo: NotesRepository
){
    suspend fun addnote(note: Note)=repo.addNote(note)
}