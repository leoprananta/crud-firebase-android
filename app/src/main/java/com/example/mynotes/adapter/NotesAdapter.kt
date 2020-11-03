package com.example.mynotes.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.R
import com.example.mynotes.model.Notes
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_notes.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NotesAdapter (private val context: Context, private val items: List<Notes>, private val listener: (Notes) -> Unit)
    : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_notes, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(items: Notes, listener: (Notes) -> Unit) {
            val remove = items.date.replace("/", " ")
            val date = remove.substring(0, 6)
            itemView.textView_itemListNotes_notesTitle.text = items.title
            itemView.textView_itemListNotes_notesDescription.text = items.description
            itemView.textView_itemListNotes_notesDate.text = date

            containerView.onClick { listener(items) }
        }
    }
}