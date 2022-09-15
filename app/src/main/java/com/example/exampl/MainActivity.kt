package com.example.exampl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var model: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the view model
        model = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        // Specify layout for recycler view
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        // Observe the model
        model.allTasks.observe(this, Observer{ students->
            // Data bind the recycler view
            recyclerView.adapter = RecyclerViewAdapter(students)
        })

        // Кнопка добавления задания
        val btn:Button = findViewById(R.id.btn)
        btn.setOnClickListener {
//             {
                model.insert(Task(null, UUID.randomUUID().toString()))
//            }
        }
    }
}