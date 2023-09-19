package ru.borodinskiy.aleksei.biaapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import ru.borodinskiy.aleksei.biaapp.dao.BiaDao
import ru.borodinskiy.aleksei.biaapp.entity.Task
import javax.inject.Inject

class BiaRepositoryImpl @Inject constructor(private val biaDao: BiaDao) : BiaRepository {

    override val allTask: LiveData<List<Task>> = biaDao.getTasks().asLiveData()

    override suspend fun insertAll(tasks: List<Task>) {
        super.insertAll(tasks)
    }
    override fun getTaskById(id: Int): LiveData<List<Task>> = biaDao.getTaskById(id).asLiveData()

    override suspend fun insert(task: Task) = biaDao.insert(task)
//    override suspend fun update(task: Task) = biaDao.update(task)
//
//    override suspend fun delete(task: Task) = biaDao.delete(task)
//
//    override suspend fun save(task: Task) = biaDao.save(task)

}