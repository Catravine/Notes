package com.carolinecourtney.notes.notes

import com.carolinecourtney.notes.application.NoteApplication
import com.carolinecourtney.notes.database.RoomDatabaseClient
import com.carolinecourtney.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakedata(): MutableList<Note> = retrieveNotes().toMutableList()

    override fun addNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().addNote(note)
        callback.invoke(true)
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().updateNote(note)
        callback.invoke(true)
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().deleteNote(note)
        callback.invoke(true)
    }

    override fun retrieveNotes(): List<Note> = databaseClient.noteDAO().retrieveNotes()

}