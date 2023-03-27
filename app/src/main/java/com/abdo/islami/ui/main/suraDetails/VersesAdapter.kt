package com.abdo.islami.ui.main.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdo.islami.R

class VersesAdapter : RecyclerView.Adapter<VersesAdapter.VersesViewHolder>() {
    var verses: List<String>? = null

    fun changeData(verses: List<String>) {
        this.verses = verses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse, parent, false)
        return VersesViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {

        holder.content.setText(verses?.get(position))
    }

    override fun getItemCount(): Int = verses?.size ?: 0


    class VersesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content_of_sura)
    }
}