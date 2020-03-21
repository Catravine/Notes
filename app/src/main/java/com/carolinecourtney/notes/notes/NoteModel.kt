package com.carolinecourtney.notes.notes

import com.carolinecourtney.notes.models.Note
import javax.inject.Inject

class NoteModel @Inject constructor() {

    fun getFakedata(): MutableList<Note> = mutableListOf(
        Note("Note Test One"),
        Note("Note Test Two")
    )

}