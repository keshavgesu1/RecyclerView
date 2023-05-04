package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

 class ToDoAdapter(
    var todo: List<ToDo>
) : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textView_1)
        val button = itemView.findViewById<CheckBox>(R.id.cbDone)

        fun bind(item: ToDo) {
            textView.text = item.title
            button.isChecked = item.isChecked
        }
    }

    override fun getItemCount(): Int {
       return todo.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return  TodoViewHolder(view.rootView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) =
        holder.bind(todo[position])

}