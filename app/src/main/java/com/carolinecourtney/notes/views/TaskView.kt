package com.carolinecourtney.notes.views

import android.content.Context
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

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit, deleteCallback: () -> Unit) {
        resetChildViews()
        this.task = task
        initTaskLine(deleteCallback)
        addChildViews(todoCheckedCallback)
    }

    private fun resetChildViews() {
        todo_container.removeAllViewsInLayout()
    }

    private fun initTaskLine(deleteCallback: () -> Unit) {
        title_view.text = task.title
        image_button.setOnClickListener {
            deleteCallback.invoke()
        }
    }

    private fun addChildViews(todoCheckedCallback: (Int, Boolean) -> Unit) {
        task.todos.forEachIndexed { todoIndex, todo ->
        val todoView = (LayoutInflater.from(context)
            .inflate(R.layout.view_todo, todo_container, false) as TodoView).apply {
            initView(todo) { isChecked ->
                todoCheckedCallback.invoke(todoIndex, isChecked)
                if (isTaskComplete()) {
                    this@TaskView.title_view.setStrikeThrough()
                } else {
                    this@TaskView.title_view.removeStrikeThrough()
                }
            }
        }
        todo_container.addView(todoView)
    }

    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()
}