package com.carolinecourtney.notes.tasks

import android.util.Log
import com.carolinecourtney.notes.application.NoteApplication
import com.carolinecourtney.notes.database.RoomDatabaseClient
import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {

    private var databaseClient =RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Task> = mutableListOf(
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

    override fun addTask(task: Task, callback: SuccessCallback) {
        Log.d("UdemyCourse", task.toString())
        callback.invoke(true)
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveTasks(): List<Task> {
        TODO("Not yet implemented")
    }

}