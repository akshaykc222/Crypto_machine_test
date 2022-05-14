package com.example.crypto_machine_test.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.crypto_machine_test.Dao.CurrencyDao
import com.example.crypto_machine_test.enitity.CurrencyEntity


@Database(entities = [CurrencyEntity::class],version = 1)
abstract class AppDatabase:RoomDatabase() {


    abstract fun currencyDao(): CurrencyDao


    companion object{
        private var instance: AppDatabase? = null
        @Synchronized
        open fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "AppDatabase")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}