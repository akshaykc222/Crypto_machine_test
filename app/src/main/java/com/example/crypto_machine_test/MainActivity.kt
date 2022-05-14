package com.example.crypto_machine_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto_machine_test.ViewModels.CurrencyListViewModel
import com.example.crypto_machine_test.adapter.CurrencyListAdapter
import com.example.crypto_machine_test.models.CurrencyModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import android.text.Editable





class MainActivity : AppCompatActivity() {
    private var viewModel: CurrencyListViewModel?= null
    lateinit  var currencyRecycler:RecyclerView
    private  val tag ="MainActivity";
    lateinit var currencyListAdapter: CurrencyListAdapter
    lateinit var search:EditText
    var swipeRefreshLayout: SwipeRefreshLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //did't used dependency injection




        search=findViewById(R.id.search)
        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.length>3){
                    currencyListAdapter.filter.filter(s)
                }else{
                    pullData()
                }

            }
        })
        swipeRefreshLayout=findViewById(R.id.swipeRefresh)
        currencyRecycler =findViewById(R.id.currencyRecycle)
        currencyRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        currencyListAdapter = CurrencyListAdapter(this)
        currencyRecycler.adapter=currencyListAdapter
        //swipe refresher

        swipeRefreshLayout!!.setOnRefreshListener {
            swipeRefreshLayout!!.isRefreshing = false
        pullData()
        }

        //pullind data from api
      pullData()


    }
    private fun pullData(){
        viewModel = ViewModelProvider(this)[CurrencyListViewModel::class.java]
        viewModel!!.getCurrencyList()?.observe(this){
                volumesResponse ->
            Log.d(tag,"volume response size ${volumesResponse.data.size}")
            if (volumesResponse!=null){
                currencyListAdapter.setList(volumesResponse.data as ArrayList<CurrencyModel>)


            }
        }
    }
}