package com.carolinecourtney.notes.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.carolinecourtney.notes.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NoteListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: NoteAdapter
    private lateinit var touchActionDelegate: NoteListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: NoteListViewContract

    fun initView(
        taDelegate: NoteListFragment.TouchActionDelegate,
        daDelegate: NoteListViewContract
    ) {
        setUpDelegates(taDelegate, daDelegate)
        setupView()
    }

    private fun setUpDelegates(
        taDelegate: NoteListFragment.TouchActionDelegate,
        daDelegate: NoteListViewContract
    ) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    private fun setupView() {
        notes_recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = NoteAdapter(
            touchActionDelegate = touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        notes_recycler_view.adapter = adapter
    }

    fun updateList(list: List<Note>) {
        adapter.updateList(list)
    }
}