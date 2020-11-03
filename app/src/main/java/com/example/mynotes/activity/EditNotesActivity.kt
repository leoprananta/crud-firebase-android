package com.example.mynotes.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mynotes.R
import org.jetbrains.anko.startActivity

class EditNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_notes)

        val back = findViewById<ImageView>(R.id.back_edit)
        val btnEdit = findViewById<Button>(R.id.btn_edit)

        back.setOnClickListener {
            startActivity<MainActivity>()
        }

        btnEdit.setOnClickListener {
            startActivity<MainActivity>()
        }

    }
}