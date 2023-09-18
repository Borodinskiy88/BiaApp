package ru.borodinskiy.aleksei.biaapp.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.borodinskiy.aleksei.biaapp.db.BiaDatabase

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun provideBiaDao(db: BiaDatabase): BiaDao = db.biaDao()
}