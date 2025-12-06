package com.example.prosync.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.prosync.Viewmodel.notesviewmodel
import com.example.prosync.model.Note


@Composable
fun notelist(navController: NavHostController,viewModel: notesviewmodel = hiltViewModel()) {
     val notes by viewModel.notes.collectAsStateWithLifecycle()


    LazyColumn {
        items(notes){
           noteitem(it)
        }
    }
}

@Composable
fun noteitem(note: Note){
    Column(Modifier.padding(16.dp).fillMaxWidth()) {
        Text(text = note.title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = note.content, style = MaterialTheme.typography.bodyMedium)
    }
}