package com.carolinecourtney.notes.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.carolinecourtney.notes.models.Task
import kotlinx.android.synthetic.main.fragment_tasks_list.view.*

class TaskListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: TaskAdapter
    private lateinit var touchActionDelegate: TasksListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract

    fun initView(
        taDelegate: TasksListFragment.TouchActionDelegate,
        daDelegate: TaskListViewContract
    ) {
        setUpDelegates(taDelegate, daDelegate)
        setupView()
    }

    private fun setUpDelegates(
        taDelegate: TasksListFragment.TouchActionDelegate,
        daDelegate: TaskListViewContract
    ) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    private fun setupView() {
        tasks_recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(
            touchActionDelegate = touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        tasks_recycler_view.adapter = adapter
    }

    fun updateList(list: List<Task>) {
        adapter.updateList(list)
    }
}