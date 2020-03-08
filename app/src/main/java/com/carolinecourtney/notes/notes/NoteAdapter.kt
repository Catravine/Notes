package com.carolinecourtney.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.foundations.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.item_note.view.*
import com.carolinecourtney.notes.models.Note

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
            view.description_view.text = data.description
        }
    }
}