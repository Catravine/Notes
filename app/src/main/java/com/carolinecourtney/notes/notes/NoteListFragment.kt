package com.carolinecourtney.notes.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.carolinecourtney.notes.R

class NoteListFragment : Fragment() {

    lateinit var viewModel: NoteViewModel
    lateinit var contentView: NoteListView
    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.let {
            if (it is TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes_list, container, false).apply {
            contentView = this as NoteListView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setContentView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    private fun setContentView() {
        contentView.initView(touchActionDelegate, viewModel)
    }

    private fun bindViewModel() {
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java) // new way
        viewModel.noteListLiveData.observe(viewLifecycleOwner, Observer { noteList ->
            contentView.updateList(noteList)
        })
    }

    companion object {
        fun newInstance() = NoteListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}