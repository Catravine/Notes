package com.carolinecourtney.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit) {
        this.task = task
        title_view.text = task.title
        task.todos.forEachIndexed { todoIndex, todo ->
            val todoView = (LayoutInflater.from(context)
                .inflate(R.layout.view_todo, todo_container, false) as TodoView).apply {
                initView(todo) { isChecked ->

                    todoCheckedCallback.invoke(todoIndex, isChecked)

                    if (isTaskComplete()) {
                        createStrikeThrough()
                    } else {
                        removeStrikeThrough()
                    }
                }
            }
            todo_container.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()

    private fun createStrikeThrough() {
        title_view.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        title_view.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}