package com.example.crypto_machine_test.ViewModels

import androidx.lifecycle.AndroidViewModel
import android.app.Application
import androidx.lifecycle.LiveData
import com.example.crypto_machine_test.models.CurrencyList
import com.example.crypto_machine_test.models.CurrencyModel
import com.example.crypto_machine_test.repositary.CurrencyRepository

class CurrencyListViewModel(application: Application) : AndroidViewModel(application) {
    private var CurrencyRepository: CurrencyRepository?=null
    private var CurrencyList: LiveData<CurrencyList>? =null


  init {
      CurrencyRepository = CurrencyRepository()
      CurrencyRepository!!.readData()
      CurrencyList= CurrencyRepository!!.getCurrencyLiveData()
  }

    fun getCurrencyList():LiveData<CurrencyList>? = CurrencyList
}