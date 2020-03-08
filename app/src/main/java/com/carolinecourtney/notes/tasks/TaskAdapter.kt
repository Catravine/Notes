package com.carolinecourtney.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.foundations.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.item_task.view.*
import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.views.TodoView

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
) : BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_task, parent, false)
        )

    class ViewHolder(view: View): BaseViewHolder<Task>(view) {

        override fun onBind(data: Task) {
            view.title_view.text = data.title
            data.todos.forEach { todo ->
                val todoView = (LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todo_container, false) as TodoView).apply {
                    initView(todo)
                }
                view.todo_container.addView(todoView)
            }
        }
    }
}