package com.carolinecourtney.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.foundations.BaseRecyclerAdapter
import com.carolinecourtney.notes.models.Note
import com.carolinecourtney.notes.views.NoteView

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf()
) : BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_note, parent, false)
        )

    class ViewHolder(view: View): BaseViewHolder<Note>(view) {

        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }
}