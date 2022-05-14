package com.example.crypto_machine_test.Database

import com.example.crypto_machine_test.enitity.CurrencyEntity

interface DatabaseHelper {

    suspend fun getCurrency(): List<CurrencyEntity>

    suspend fun insertAll(users: List<CurrencyEntity>)

}