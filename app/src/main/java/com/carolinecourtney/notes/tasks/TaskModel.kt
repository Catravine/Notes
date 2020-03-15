package com.carolinecourtney.notes.tasks

import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.Todo

class TaskModel {


    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing One", mutableListOf(
                Todo("Test Todo One", true),
                Todo("Test Todo Two")
            )
        ),
        Task("Testing Two"),
        Task(
            "Testing Three!", mutableListOf(
                Todo("Test A"),
                Todo("Test B")
            )
        )
    )

}