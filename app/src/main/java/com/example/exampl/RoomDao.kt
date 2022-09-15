package com.example.exampl

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao{
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun allTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)
}