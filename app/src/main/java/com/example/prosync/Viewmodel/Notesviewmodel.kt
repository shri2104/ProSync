package com.example.prosync.Viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prosync.Domain.usecase.addnote
import com.example.prosync.Domain.usecase.getnoteusecase
import com.example.prosync.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class notesviewmodel @Inject constructor(
    private val Addnote: addnote,
    private val getnotes: getnoteusecase
):ViewModel(){
    private val _notes=MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    init{
         loadnotes()
    }
    fun loadnotes(){
        viewModelScope.launch {
            getnotes.getnotes().collect {
                _notes.value=it
            }
        }
    }
    fun addnote(note:Note){
        viewModelScope.launch {
            Addnote.addnote(note)
        }
    }
}