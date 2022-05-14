package com.example.crypto_machine_test.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class  CurrencyList(
     @SerializedName("data")
     @Expose
     val data:List<CurrencyModel>
)

class CurrencyModel(
     @SerializedName("id")
     @Expose
     val id:String,
     @SerializedName("rank")
     @Expose
     val rank:String,
     @SerializedName("symbol")
     @Expose
     val symbol:String,
     @SerializedName("name")
     @Expose
     val name:String,
     @SerializedName("supply")
     @Expose
     val supply:String,
     @SerializedName("maxSupply")
     @Expose
     val maxSupply:String,
     @SerializedName("marketCapUsd")
     @Expose
     val marketCapUsd:String,
     @SerializedName("volumeUsd24Hr")
     @Expose
     val volumeUsd24Hr:String,
     @SerializedName("priceUsd")
     @Expose
     val priceUsd:String,
     @SerializedName("changePercent24Hr")
     @Expose
     val changePercent24Hr:String,
     @SerializedName("vwap24Hr")
     @Expose
     val vwap24Hr:String,
     @SerializedName("explorer")
     @Expose
     val explorer:String
)