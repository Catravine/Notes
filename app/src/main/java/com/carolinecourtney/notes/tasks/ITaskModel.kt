package com.carolinecourtney.notes.tasks

import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.Todo

typealias SuccessCallback = (Boolean) -> Unit

interface ITaskModel {

    fun addTask(task: Task, callback: SuccessCallback)
    fun updateTask(task: Task, callback: SuccessCallback)
    fun updateTodo(todo: Todo, callback: SuccessCallback)
    fun deleteTask(task: Task, callback: SuccessCallback)
    fun retrieveTasks(): List<Task>

    fun getFakeData(): MutableList<Task>

}