package com.carolinecourtney.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinecourtney.notes.foundations.ApplicationScope
import com.carolinecourtney.notes.models.Task
import toothpick.Toothpick
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewContract {

    @Inject
    lateinit var model: ITaskModel

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    init {
        Toothpick.inject(this, ApplicationScope.scope)
        loadData()
    }

    fun loadData() {
        _taskListLiveData.postValue((model.retrieveTasks().toMutableList()))
    }

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.let {
            val todo = it[taskIndex].todos[todoIndex]
            todo.apply {
                this.isComplete = isComplete
                this.taskId = it[taskIndex].uid
            }
            model.updateTodo(todo) {
                loadData()
            }
        }
    }

    override fun onTaskDeleted(taskIndex: Int) {
        _taskListLiveData.value?.let {
            model.deleteTask(it[taskIndex]) {
                loadData()
            }
        }
    }
}