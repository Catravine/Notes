package com.carolinecourtney.notes.notes

import com.carolinecourtney.notes.models.Note

class NoteModel {

    fun getFakedata(): MutableList<Note> = mutableListOf(
        Note("Note Test One"),
        Note("Note Test Two")
    )

}