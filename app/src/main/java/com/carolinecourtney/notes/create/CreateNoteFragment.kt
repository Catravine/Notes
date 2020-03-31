package com.carolinecourtney.notes.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.foundations.ApplicationScope
import com.carolinecourtney.notes.foundations.NullFieldChecker
import com.carolinecourtney.notes.models.Note
import com.carolinecourtney.notes.notes.INoteModel
import kotlinx.android.synthetic.main.fragment_create_note.*
import toothpick.Toothpick
import javax.inject.Inject

class CreateNoteFragment : Fragment(), NullFieldChecker {

    @Inject
    lateinit var model: INoteModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toothpick.inject(this, ApplicationScope.scope)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    fun saveNote(callback: (Boolean) -> Unit) {
        createNote()?.let {
            model.addNote(it) {
                callback.invoke(true)
            }
        } ?: callback.invoke(false)
    }

    private fun createNote(): Note? = if (!hasNullField()) Note(description = note_edit_text.editableText.toString()) else null

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    override fun hasNullField(): Boolean = note_edit_text.editableText.isNullOrEmpty()

    companion object {
        fun newInstance() = CreateNoteFragment()
    }
}
