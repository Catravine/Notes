package com.carolinecourtney.notes.foundations

import com.carolinecourtney.notes.notes.INoteModel
import com.carolinecourtney.notes.notes.NoteLocalModel
import com.carolinecourtney.notes.tasks.ITaskModel
import com.carolinecourtney.notes.tasks.TaskLocalModel
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope {
    val scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModules)
    }
}

object ApplicationModules: Module() {
    init {
        bind(INoteModel::class.java).toInstance(NoteLocalModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}