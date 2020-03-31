package com.carolinecourtney.notes.notes

import com.carolinecourtney.notes.models.Note

interface NoteListViewContract {
    fun onDeleteNote(note: Note)
}