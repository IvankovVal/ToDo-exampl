package com.example.exampl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey
    var id:Long?,

    @ColumnInfo(name = "uuid")
    var name: String
)