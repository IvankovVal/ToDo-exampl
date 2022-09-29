package com.example.exampl

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import androidx.fragment.app.DialogFragment


class MainActivity : AppCompatActivity(),RecyclerViewAdapter.OnItemClickListener {

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
            recyclerView.adapter = RecyclerViewAdapter(students,this)
        })

        // Кнопка добавления задания
        val btn:Button = findViewById(R.id.btn)
        btn.setOnClickListener {
       val add_dialog = AddTaskDialog()
            val manager = supportFragmentManager
            add_dialog.show(manager,"add_dialog")
                        }
                     }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Пункт $position нажат", Toast.LENGTH_LONG).show()
        val ditaile_dialog = DitaileDialog()
        val manager = supportFragmentManager
        ditaile_dialog.show(manager,"add_dialog")
    }


}
