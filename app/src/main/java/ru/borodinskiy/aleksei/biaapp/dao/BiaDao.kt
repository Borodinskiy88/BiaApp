package ru.borodinskiy.aleksei.biaapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.borodinskiy.aleksei.biaapp.entity.Task

@Dao
interface BiaDao {

    //TODO заполнение БД
    @Transaction
    suspend fun insertAll(tasks: List<Task>) {
        tasks.forEach { insert(it) }
    }

    //Task
    @Query("SELECT * FROM Task ORDER BY id DESC")
    fun getTasks(): Flow<List<Task>>
    @Query("SELECT * from Task WHERE id = :id")
    fun getTaskById(id: Int): Flow<Task>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)
    @Update
    suspend fun update(task: Task)
    @Delete
    suspend fun delete(task: Task)
    @Upsert
    suspend fun save(task: Task)

}