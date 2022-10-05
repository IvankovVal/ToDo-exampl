package com.example.exampl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(
    val tasks: List<Task>,
private val listener: OnItemClickListener)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private lateinit var model: TaskViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view,parent,false)
        return ViewHolder(v)
    }
//________________________________________________________________________
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = tasks[position].id.toString()
        holder.name.text = tasks[position].name

    }
    //________________________________________________________________________
    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        val id: TextView = itemView.findViewById(R.id.tvId)
        val name: TextView = itemView.findViewById(R.id.tvName)
        //val chekbox: CheckBox = itemView.findViewById(R.id.cbStatus)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
            listener.onItemClick(position)}
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}