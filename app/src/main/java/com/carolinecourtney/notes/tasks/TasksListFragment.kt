package com.carolinecourtney.notes.tasks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.carolinecourtney.notes.R
import kotlinx.android.synthetic.main.fragment_tasks_list.*
import com.carolinecourtney.notes.models.Task
import com.carolinecourtney.notes.models.Todo

class TasksListFragment : Fragment() {

    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (it is TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasks_recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(
            mutableListOf(
                Task(
                    "Testing One", mutableListOf(
                        Todo("Test Todo One", true),
                        Todo("Test Todo Two")
                    )
                ),
                Task("Testing Two")
            ),
            touchActionDelegate
        )
        tasks_recycler_view.adapter = adapter
    }

    companion object {
        fun newInstance() = TasksListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}