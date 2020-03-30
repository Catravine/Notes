package com.carolinecourtney.notes.tasks

import com.carolinecourtney.notes.application.NoteApplication
import com.carolinecourtney.notes.database.RoomDatabaseClient
import com.carolinecourtney.notes.models.Task
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {

    private var databaseClient =RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Task> = retrieveTasks().toMutableList()

    override fun addTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().addTask(task)
        callback.invoke(true)
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().updateTask(task)
        callback.invoke(true)
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().deleteTask(task)
        callback.invoke(true)
    }

    override fun retrieveTasks(): List<Task> {
        databaseClient.taskDAO().retrieveTasks()
    }

}