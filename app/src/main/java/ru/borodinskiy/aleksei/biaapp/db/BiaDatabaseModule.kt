package ru.borodinskiy.aleksei.biaapp.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class BiaDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext
        context: Context
    ): BiaDatabase = Room.databaseBuilder(context, BiaDatabase::class.java, "bia_db")
        .fallbackToDestructiveMigration()
        .build()
}