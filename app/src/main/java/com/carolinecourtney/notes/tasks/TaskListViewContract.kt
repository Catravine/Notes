package com.carolinecourtney.notes.tasks

interface TaskListViewContract {

    fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean)
    fun onTaskDeleted(taskIndex: Int)
}