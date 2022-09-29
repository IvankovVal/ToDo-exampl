package com.example.exampl

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao{
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun allTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Delete()
    fun delete_task(task: Task)

//    @Delete(entity = Task::class)
//    fun delete_task(task: Task)
}