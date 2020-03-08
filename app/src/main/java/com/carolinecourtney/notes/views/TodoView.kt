package com.carolinecourtney.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.carolinecourtney.notes.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(todo: Todo) {
        description_view!!.text = todo.description
        complete_checkbox!!.isChecked = todo.isComplete
        if (todo.isComplete) createStrikeThrough()
        setUpCheckStateListener()
    }

    private fun setUpCheckStateListener() {
        complete_checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrough()
            }
        }
    }

    private fun createStrikeThrough() {
        description_view.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        description_view.apply {
            paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}