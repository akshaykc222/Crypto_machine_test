package com.example.crypto_machine_test.enitity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey val id:String,
    @ColumnInfo val rank:String,
    @ColumnInfo val symbol:String,
    @ColumnInfo val name:String,
    @ColumnInfo val supply:String,
    @ColumnInfo val maxSupply:String,
    @ColumnInfo val marketCapUsd:String,
    @ColumnInfo val volumeUsd24Hr:String,
    @ColumnInfo val priceUsd:String,
    @ColumnInfo val changePercent24Hr:String,
    @ColumnInfo val vwap24Hr:String,
    @ColumnInfo val explorer:String
)