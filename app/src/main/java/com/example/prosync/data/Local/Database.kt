package com.example.prosync.data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prosync.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class ProsyncDB: RoomDatabase(){
    abstract fun noteDao(): NoteDao
}

