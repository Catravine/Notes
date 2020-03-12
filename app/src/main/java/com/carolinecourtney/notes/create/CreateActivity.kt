package com.carolinecourtney.notes.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carolinecourtney.notes.R
import com.carolinecourtney.notes.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            textView.text = if (this == NavigationActivity.FRAGMENT_VALUE_NOTE) {
                "This is a Note!"
            } else if (this == NavigationActivity.FRAGMENT_VALUE_TASK) {
                "This is a Task!"
            } else "this is nothing."
        }
    }
}