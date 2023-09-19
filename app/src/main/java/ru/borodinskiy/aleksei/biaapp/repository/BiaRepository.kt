package ru.borodinskiy.aleksei.biaapp.repository

import androidx.lifecycle.LiveData
import ru.borodinskiy.aleksei.biaapp.entity.Task

interface BiaRepository {

    suspend fun insertAll(tasks: List<Task>) {
        tasks.forEach { insert(it) }
    }

    val allTask: LiveData<List<Task>>

    fun getTaskById(id: Int): LiveData<List<Task>>

    suspend fun insert(task: Task)

}