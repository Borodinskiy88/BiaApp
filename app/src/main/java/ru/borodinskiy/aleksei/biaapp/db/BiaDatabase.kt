package ru.borodinskiy.aleksei.biaapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.borodinskiy.aleksei.biaapp.dao.BiaDao
import ru.borodinskiy.aleksei.biaapp.entity.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class BiaDatabase : RoomDatabase() {
    abstract fun biaDao(): BiaDao

}