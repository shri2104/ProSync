package com.example.prosync.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 ──────────────────────────────────────────────────────────────
 DOMAIN MODEL (Used by ViewModel, UseCases, UI)
 ──────────────────────────────────────────────────────────────
 This model does NOT know about Room, Retrofit, or storage.
 It only represents the pure business object.
*/
data class Note(
        val id: Int = 0,
        val title: String,
        val content: String,
        val updatedAt: Long = System.currentTimeMillis(),
        val isSynced: Boolean = false
)



/*
 ──────────────────────────────────────────────────────────────
 ROOM ENTITY (Local Database)
 ──────────────────────────────────────────────────────────────
 This model defines how the data is stored in the local DB.
 It may have extra attributes (localId, sync flags, etc.)
*/
@Entity(tableName = "notes")
data class NoteEntity(
        @PrimaryKey(autoGenerate = true)
        val localId: Int = 0,
        val title: String,
        val content: String,
        val updatedAt: Long,
        val isSynced: Boolean = false
)



/*
 ──────────────────────────────────────────────────────────────
 API DTO (Network Model)
 ──────────────────────────────────────────────────────────────
 This model represents how backend sends or expects data.
 Structure/naming may differ from domain and Room model.
*/
data class NoteDto(
        val id: String,
        val title: String,
        val content: String,
        val updated_at: String,
        val version: Int,
        val ownerId: Int
)



/*
 ──────────────────────────────────────────────────────────────
 MAPPING EXTENSIONS (The "glue" between layers)
 ──────────────────────────────────────────────────────────────
 These ensure layers stay independent and swappable.
*/



// ROOM ENTITY → DOMAIN MODEL
fun NoteEntity.toDomain(): Note {
        return Note(
                id = localId,
                title = title,
                content = content,
                updatedAt = updatedAt,
                isSynced = isSynced
        )
}



// DOMAIN MODEL → ROOM ENTITY
fun Note.toEntity(): NoteEntity {
        return NoteEntity(
                localId = id,
                title = title,
                content = content,
                updatedAt = updatedAt,
                isSynced = isSynced
        )
}



// DTO (API RESPONSE) → DOMAIN MODEL
fun NoteDto.toDomain(): Note {
        return Note(
                id = extractLocalId(id), // hypothetical logic
                title = title,
                content = content,
                updatedAt = parseDate(updated_at),
                isSynced = true // synced because it came from server
        )
}



// DOMAIN MODEL → DTO (For uploading to server)
fun Note.toDto(): NoteDto {
        return NoteDto(
                id = "note-$id",                     // backend expects string id
                title = title,
                content = content,
                updated_at = updatedAt.toString(),  // convert Long → string timestamp
                version = 1,
                ownerId = 999
        )
}



/*
 ──────────────────────────────────────────────────────────────
 HELPER FUNCTIONS (Mock examples for transformation)
 ──────────────────────────────────────────────────────────────
 These simulate format conversion between layers.
*/

private fun extractLocalId(serverId: String): Int {
        return serverId.filter { it.isDigit() }.toIntOrNull() ?: 0
}

private fun parseDate(value: String): Long {
        return System.currentTimeMillis() // Replace with real parsing later
}
