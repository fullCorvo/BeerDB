package com.example.beerdb.repositories

import androidx.lifecycle.MutableLiveData
import com.example.beerdb.models.BeerModel
import com.example.beerdb.request.PunkApiClient

class BeerRepository {

    // this class acts like a repository

    private val punkApiClient = PunkApiClient()

    fun getBeers() : MutableLiveData<List<BeerModel>?> {
        return punkApiClient.getBeers()
    }

    fun searchBeers(query: String){
        punkApiClient.searchBeers(query)
    }
}