package com.example.prosync.Domain.usecase

import com.example.prosync.data.Repository.NotesRepository
import javax.inject.Inject


class getnoteusecase @Inject constructor(
    private val repo: NotesRepository
){
    fun getnotes()=repo.getnotes()
}