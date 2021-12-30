package com.example.androiddev2k1s.database

import androidx.room.*
import com.example.androiddev2k1s.models.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllTasks(): List<Task>

    @Query("SELECT * FROM task WHERE id = :id")
    fun getTaskById(id: Int): Task?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(task: Task)

    @Update
    fun updateTasks(vararg tasks: Task)

    @Query("DELETE FROM task WHERE id = :id")
    fun deleteTaskById(id: Int)

    @Query("DELETE FROM task")
    fun deleteAll()
}