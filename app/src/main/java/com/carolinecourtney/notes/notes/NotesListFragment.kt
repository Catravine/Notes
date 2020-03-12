package com.carolinecourtney.notes.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.carolinecourtney.notes.R
import kotlinx.android.synthetic.main.fragment_notes_list.*
import com.carolinecourtney.notes.models.Note

class NotesListFragment : Fragment() {

    lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (it is NotesListFragment.TouchActionDelegate) {
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
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notes_recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(
            mutableListOf(
                Note("Note Test One"),
                Note("Note Test Two")
            ),
            touchActionDelegate
        )
        notes_recycler_view.adapter = adapter
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}