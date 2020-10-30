package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import org.jetbrains.anko.startActivity

class AddNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        val back = findViewById<ImageView>(R.id.back_add)
        val btnAdd = findViewById<Button>(R.id.btn_add)

        back.setOnClickListener {
            startActivity<MainActivity>()
        }

        btnAdd.setOnClickListener {
            startActivity<MainActivity>()
        }

    }
}