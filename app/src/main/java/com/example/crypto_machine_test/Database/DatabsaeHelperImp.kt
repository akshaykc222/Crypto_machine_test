package com.example.crypto_machine_test.Database

import com.example.crypto_machine_test.enitity.CurrencyEntity

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getCurrency(): List<CurrencyEntity> = appDatabase.currencyDao().getAll()

    override suspend fun insertAll(currenncyList: List<CurrencyEntity>) = appDatabase.currencyDao().insertAll(currenncyList)

}