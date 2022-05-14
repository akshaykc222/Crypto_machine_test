package com.example.crypto_machine_test.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.crypto_machine_test.Dao.CurrencyDao
import com.example.crypto_machine_test.enitity.CurrencyEntity
import android.os.AsyncTask

import androidx.sqlite.db.SupportSQLiteDatabase

import androidx.annotation.NonNull





@Database(entities = [CurrencyEntity::class],version = 1)
abstract class AppDatabase:RoomDatabase() {


    abstract fun currencyDao(): CurrencyDao




}