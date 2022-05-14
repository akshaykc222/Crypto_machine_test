package com.example.crypto_machine_test.Retrofit



import com.example.crypto_machine_test.models.CurrencyList
import com.example.crypto_machine_test.models.CurrencyModel

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("/v2/assets")
   fun getAllCurrency():Call<CurrencyList>



}