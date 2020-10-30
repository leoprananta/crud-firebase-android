package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab_main)
        val card = findViewById<CardView>(R.id.card_view_1)

        fab.setOnClickListener {
            startActivity<AddNotesActivity>()
        }

        card.setOnClickListener {
            startActivity<ReadNotesActivity>()
        }

    }
}