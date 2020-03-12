package com.carolinecourtney.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.Todo

class TaskViewModel: ViewModel() {

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    init {
        _taskListLiveData.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing One", mutableListOf(
                Todo("Test Todo One", true),
                Todo("Test Todo Two")
            )
        ),
        Task("Testing Two"),
        Task("Testing Three!", mutableListOf(
            Todo("Test A"),
            Todo("Test B")
        ))
    )
}