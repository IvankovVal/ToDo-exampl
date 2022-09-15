package com.example.exampl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.custom_view.view.*

class RecyclerViewAdapter(val tasks: List<Task>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = tasks[position].id.toString()
        holder.name.text = tasks[position].name
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val id:TextView = itemView.findViewById(R.id.tvId)
        val name:TextView = itemView.findViewById(R.id.tvName)
    }
}