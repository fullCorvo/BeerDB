package com.example.beerdb.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.beerdb.models.BeerModel
import com.example.beerdb.request.PunkApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepository @Inject constructor(private val punkApiClient: PunkApiClient) {

    // this class acts like a repository

    fun getBeers() : MutableLiveData<List<BeerModel>?> {
        return punkApiClient.getBeers()
    }

    fun searchBeers(query: String){
        Log.d("Beer Repository", "Inside searchBeers")
        punkApiClient.searchBeers(query)
    }
}