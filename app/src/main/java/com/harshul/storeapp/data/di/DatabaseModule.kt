package com.harshul.storeapp.data.di

import android.content.Context
import androidx.room.Room
import com.harshul.storeapp.data.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(context: Context): FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB").build()
    }

}