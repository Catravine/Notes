package com.carolinecourtney.notes.notes

import com.carolinecourtney.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel {

    override fun getFakedata(): MutableList<Note> = mutableListOf(
        Note("Note Test One"),
        Note("Note Test Two")
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
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