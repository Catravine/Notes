package com.carolinecourtney.notes.application

import android.app.Application

class NoteApplication: Application(){

    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }
}