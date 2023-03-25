package com.abdo.islami.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdo.islami.R

class SuraNameAdapter(val items: List<String>) :
    RecyclerView.Adapter<SuraNameAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter_name, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = items[position]
        holder.name.text = suraName
//        onItemClickListener.let {
//            ClickListener ->
//            holder.itemView.setOnClickListener {
//                onItemClickListener?.onItemClick(position,suraName)
//            }
//        }
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, suraName)
            }
        }
    }

    override fun getItemCount(): Int = items.size
    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int, name: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_of_sura)
    }
}