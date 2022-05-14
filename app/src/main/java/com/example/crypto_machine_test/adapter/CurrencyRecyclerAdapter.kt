package com.example.crypto_machine_test.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto_machine_test.R
import com.example.crypto_machine_test.models.CurrencyModel
import java.util.*
import kotlin.collections.ArrayList

class CurrencyListAdapter(private val context:Context):RecyclerView.Adapter<CurrencyListAdapter.ViewHolder>(),
    Filterable {
    private var currencyList:ArrayList<CurrencyModel> = ArrayList()
    var  filterList:List<CurrencyModel> = ArrayList()
    var  tempList:List<CurrencyModel> =ArrayList()

    fun setList(modelList:ArrayList<CurrencyModel>){
        tempList=modelList
        currencyList=modelList
        Log.d("ADAPTER",currencyList.size.toString())
        notifyDataSetChanged()

    }

    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val name: TextView =item.findViewById(R.id.name)
        val price: TextView =item.findViewById(R.id.price)
        val change: TextView =item.findViewById(R.id.change)
        val image:TextView =item.findViewById(R.id.imageView)
        val index:TextView =item.findViewById(R.id.index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item= LayoutInflater.from(parent.context).inflate(R.layout.currency_list_adapter,parent,false)
        return ViewHolder(item)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=currencyList[position]
        Log.d("changedItems","changint item ${currentItem.name}")
        holder.image.text =currentItem.symbol
        holder.index.text ="${position+1}"
        holder.name.text=currentItem.name
        holder.change.text="${currentItem.changePercent24Hr.subSequence(0,4)}%"
        holder.price.text="$ ${currentItem.priceUsd}"



    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    override fun getFilter(): Filter {
        return  object :Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.length<3) {
                    Log.d("AddingList",tempList.size.toString())
                    filterList = tempList
                } else {
                    filterList = tempList
                    val resultList = ArrayList<CurrencyModel>()
                    for (row in filterList) {
                        if (row.name.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (results != null) {
                    filterList=results.values as List<CurrencyModel>
                    currencyList= filterList.toMutableList() as ArrayList<CurrencyModel>
                    notifyDataSetChanged()
                }
            }

        }
    }

}