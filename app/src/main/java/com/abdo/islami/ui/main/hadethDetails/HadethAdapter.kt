package com.abdo.islami.ui.main.hadethDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdo.islami.R

class HadethAdapter : RecyclerView.Adapter<HadethAdapter.VersesViewHolder>() {
    var hadeth: List<String>? = null

    fun changeData(verses: List<String>) {
        this.hadeth = verses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hadeth_content, parent, false)
        return VersesViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {

        holder.content.setText(hadeth?.get(position))
    }

    override fun getItemCount(): Int = hadeth?.size ?: 0


    class VersesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content_of_hadeth)
    }
}