package com.example.exampl

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TaskViewModel(application:Application): AndroidViewModel(application){


    private val tasks: MutableLiveData<List<Task>> = MutableLiveData(listOf(Task(1,"First",false)))

    fun insert(task:Task){
        viewModelScope.launch(Dispatchers.IO) {
             tasks.value = tasks.value!!.plus(task)
        }
    }

    fun delete_task (task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            //tasks.value = tasks.value!!.
        }
    }

    fun update_task (task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            //db.taskDao().update_task(task)
        }
    }
}