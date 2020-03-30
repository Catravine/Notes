package com.carolinecourtney.notes.database

import androidx.room.*
import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.TaskEntity

@Dao
interface TaskDAO {

    @Insert
    fun addTask(taskEntity: TaskEntity)

    @Update
    fun updateTask(taskEntity: TaskEntity)

    @Delete
    fun deleteTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun retrieveTasks(): MutableList<Task>

}