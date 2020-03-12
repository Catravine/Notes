package com.carolinecourtney.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinecourtney.notes.models.Note

class NoteViewModel: ViewModel() {

    private val _notesListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val notesListLiveData: LiveData<MutableList<Note>> = _notesListLiveData

    init {
        _notesListLiveData.postValue(getFakedata())
    }

    fun getFakedata(): MutableList<Note> = mutableListOf(
        Note("Note Test One"),
        Note("Note Test Two")
    )
}