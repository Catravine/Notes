package com.carolinecourtney.notes.create

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.foundations.ApplicationScope
import com.carolinecourtney.notes.foundations.NullFieldChecker
import com.carolinecourtney.notes.foundations.StateChangeTextWatcher
import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.Todo
import com.carolinecourtney.notes.tasks.ITaskModel
import com.carolinecourtney.notes.views.CreateTodoView
import kotlinx.android.synthetic.main.fragment_create_task.*
import kotlinx.android.synthetic.main.view_create_task.view.*
import kotlinx.android.synthetic.main.view_create_todo.view.*
import toothpick.Toothpick
import javax.inject.Inject

private const val MAX_TODO_COUNT = 5

class CreateTaskFragment : Fragment() {

    @Inject
    lateinit var model: ITaskModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toothpick.inject(this, ApplicationScope.scope)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        create_task_view.task_edit_text.addTextChangedListener(object: StateChangeTextWatcher() {
            override fun afterTextChanged(s: Editable?) {

                if (!s.isNullOrEmpty() && previousValue.isNullOrEmpty()) {
                    addTodoView()
                }

                super.afterTextChanged(s)
            }
        })

    }

    private fun addTodoView() {
        if (canAddTodos()) {
            val view = (LayoutInflater.from(context)
                .inflate(R.layout.view_create_todo, container_view, false) as CreateTodoView).apply {
                todo_edit_text.addTextChangedListener(object : StateChangeTextWatcher() {
                    override fun afterTextChanged(s: Editable?) {
                        if (!s.isNullOrEmpty() && previousValue.isNullOrEmpty()) {
                            addTodoView()
                        } else if (!previousValue.isNullOrEmpty() && s.isNullOrEmpty()) {
                            removeTodoView(this@apply)
                            if (container_view.childCount == MAX_TODO_COUNT) {
                                addTodoView()
                            }
                        }
                        super.afterTextChanged(s)
                    }
                })
            }
            container_view.addView(view)
        }
    }

    private fun removeTodoView(view: View) {
        container_view.removeView(view)
    }

    private fun canAddTodos(): Boolean = (container_view.childCount < MAX_TODO_COUNT + 1) &&
            !(container_view.getChildAt(container_view.childCount - 1) as NullFieldChecker).hasNullField()

    private fun isTaskEmpty(): Boolean = create_task_view.task_edit_text.editableText.isNullOrEmpty()

    fun saveTask(callback: (Boolean) -> Unit) {
        createTask()?.let {
            model.addTask(it) {
                callback.invoke(true)
            }
        } ?: callback.invoke(false)
    }

    fun createTask(): Task? {
        if (!isTaskEmpty()) {
            container_view.run {
                var taskField: String? = null
                val todoList: MutableList<Todo> = mutableListOf()
                for (i in 0 until container_view.childCount) {
                    if (i == 0) {
                        taskField = container_view.getChildAt(i).task_edit_text.editableText?.toString()
                    } else {
                        if (!container_view.getChildAt(i).todo_edit_text.editableText?.toString().isNullOrEmpty()) {
                            todoList.add(
                                Todo(description = container_view.getChildAt(i).todo_edit_text.editableText.toString())
                            )
                        }
                    }
                }
                return taskField?.let { Task(taskField, todoList) }
            }
        } else {
            return null
        }
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    companion object {
        fun newInstance() = CreateTaskFragment()
    }
}
