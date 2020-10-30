package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.jetbrains.anko.startActivity

class ReadNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_notes)

        val back = findViewById<ImageView>(R.id.back_read)
        val fab = findViewById<FloatingActionButton>(R.id.fab_read_toEdit)

        back.setOnClickListener {
            startActivity<MainActivity>()
        }

        fab.setOnClickListener {
            startActivity<EditNotesActivity>()
        }

    }
}