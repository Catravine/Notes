package com.carolinecourtney.notes.notes

import android.util.Log
import com.carolinecourtney.notes.application.NoteApplication
import com.carolinecourtney.notes.database.RoomDatabaseClient
import com.carolinecourtney.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel {

    private var databaseClient =RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakedata(): MutableList<Note> = mutableListOf(
        Note("Note Test One"),
        Note("Note Test Two")
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
       Log.d("UdemyCourse", note.toString())
        callback.invoke(true)
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveNotes(): List<Note> {
        TODO("Not yet implemented")
    }

}