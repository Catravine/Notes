package com.carolinecourtney.notes.tasks

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.foundations.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*
import com.carolinecourtney.notes.models.Task

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
                val todoView = LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todo_container, false).apply {
                    description_view.text = todo.description
                    complete_checkbox.isChecked = todo.isComplete
                    if (todo.isComplete) {
                        description_view.paintFlags = description_view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    }

                    complete_checkbox.setOnCheckedChangeListener { button, isChecked ->
                        if (isChecked) {
                            description_view.paintFlags = description_view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                        } else {
                            description_view.paintFlags = description_view.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                        }
                    }
                }
                view.todo_container.addView(todoView)
            }
        }
    }
}