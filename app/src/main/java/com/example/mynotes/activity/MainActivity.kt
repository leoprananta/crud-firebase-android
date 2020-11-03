package com.example.mynotes.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.R
import com.example.mynotes.adapter.NotesAdapter
import com.example.mynotes.model.Notes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    private var items : MutableList<Notes> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_mainActivity_notes)

        ref = FirebaseDatabase.getInstance().getReference("NOTES")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    for(h in p0.children){
                        val notes = h.getValue(Notes::class.java)
                        items.add(notes!!)
                    }
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = NotesAdapter(this@MainActivity,items){
                        toast("Yoi")
                    }
                }
            }

        })

        fab.setOnClickListener {
            startActivity<AddNotesActivity>()
        }

    }
}