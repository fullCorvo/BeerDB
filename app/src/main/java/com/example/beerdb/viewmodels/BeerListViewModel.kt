package com.example.beerdb.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerdb.models.BeerModel
import com.example.beerdb.repositories.BeerRepository

class BeerListViewModel : ViewModel() {

    // this class is use for ViewModel

    //LiveData is inside Repository, we create a Repository object to retrieve liveData
    private val beerRepository = BeerRepository()

    fun getBeers() : MutableLiveData<List<BeerModel>?> {
        return beerRepository.getBeers()
    }

    fun searchBeers(query : String){
        beerRepository.searchBeers(query)
    }
}