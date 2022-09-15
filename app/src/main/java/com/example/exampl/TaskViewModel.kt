package com.example.exampl

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TaskViewModel(application:Application): AndroidViewModel(application){
    private val db:RoomSingleton = RoomSingleton.getInstance(application)
    internal val allTasks : LiveData<List<Task>> = db.taskDao().allTasks()

    fun insert(task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            db.taskDao().insert(task)
        }
    }
}