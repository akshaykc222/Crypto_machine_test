package com.example.crypto_machine_test.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.crypto_machine_test.enitity.CurrencyEntity

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency")
    fun getAll():List<CurrencyEntity>

    @Insert
    fun insertAll(vararg sentNotification: CurrencyEntity)

    @Delete
    fun deleteWithId(sentNotification: CurrencyEntity)
}