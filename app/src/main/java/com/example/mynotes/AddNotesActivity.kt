package com.example.mynotes

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mynotes.model.Notes
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_notes.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class AddNotesActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        ref = FirebaseDatabase.getInstance().getReference("NOTES")

        val back = findViewById<ImageView>(R.id.back_add)
        val btnAdd = findViewById<Button>(R.id.btn_add)

        back.setOnClickListener {
            startActivity<MainActivity>()
        }

        btnAdd.setOnClickListener {
            saveData()
        }

    }

    private fun saveData() {
        val title = editText_addActivity_notesTitle.text.toString()
        val description = editText_addActivity_notesDescription.text.toString()

        val sdf = SimpleDateFormat("dd/MMM/yyyy")
        val date = sdf.format(Date())

        val notes = Notes(title, description, date)
        val notesId = ref.push().key.toString()

        ref.child(notesId).setValue(notes).addOnCompleteListener {
            toast("Berhasil")
            editText_addActivity_notesTitle.setText("")
            editText_addActivity_notesDescription.setText("")


        }
    }
}