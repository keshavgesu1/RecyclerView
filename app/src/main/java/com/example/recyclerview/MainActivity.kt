package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listView)
        val buttonToDo = findViewById<Button>(R.id.addButton)
        val editText = findViewById<EditText>(R.id.editText)

        var todoList = mutableListOf(
            ToDo("follow android",false),
            ToDo("follow iOS",false),
            ToDo("follow Design",true),
            ToDo("follow android",false),
            ToDo("follow iOS",true)
        )
        val adapter = ToDoAdapter(todoList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        buttonToDo.setOnClickListener {
            val title = editText.text.toString()
            val todo = ToDo(title,false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}