package com.example.cricketlive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val onItemClick: OnItemClick) : RecyclerView.Adapter<MainAdapter.MainVH>() {

    class MainVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return MainVH(view)
    }

    override fun getItemCount(): Int {
       return 10
    }

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick()
        }
    }

    interface OnItemClick {
        fun onItemClick()
    }
}