package com.example.exampl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Task(
    var id:Long?,
    var name: String,
    var status: Boolean
)