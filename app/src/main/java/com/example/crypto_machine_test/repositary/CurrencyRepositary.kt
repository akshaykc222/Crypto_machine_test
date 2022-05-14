package com.example.crypto_machine_test.repositary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.crypto_machine_test.Retrofit.RetrofitService
import com.example.crypto_machine_test.models.CurrencyList
import com.example.crypto_machine_test.models.CurrencyModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class CurrencyRepository {
    val baseUrl:String="https://api.coincap.io"
    private var retrofitService: RetrofitService?=null
    private var currencyLiveData: MutableLiveData<CurrencyList>? = null

    init {

        currencyLiveData= MutableLiveData()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(60,
            TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build()
        retrofitService= Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)

    }

    open fun readData(){

        CoroutineScope(Dispatchers.IO).launch {
            retrofitService!!.getAllCurrency(
            ).enqueue(object : Callback<CurrencyList> {
                override fun onResponse(
                    call: Call<CurrencyList>,
                    response: Response<CurrencyList>
                ) {
                    Log.d("response",response.raw().toString())
                    if (response.body()!=null){
                        currencyLiveData!!.postValue(response.body())
                    }else{
                        // Toast.makeText(this@StudentReposistary,"No data found",Toast.LENGTH_LONG).show()
                    }
                }



                override fun onFailure(call: Call<CurrencyList>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }




    }
    open fun getCurrencyLiveData(): LiveData<CurrencyList>? {

        return currencyLiveData
    }
}