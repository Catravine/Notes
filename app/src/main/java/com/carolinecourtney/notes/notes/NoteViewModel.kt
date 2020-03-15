package com.carolinecourtney.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinecourtney.notes.models.Note

class NoteViewModel : ViewModel(), NoteListViewContract {

    private val model: NoteModel = NoteModel()

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        _noteListLiveData.postValue(model.getFakedata())
    }


}