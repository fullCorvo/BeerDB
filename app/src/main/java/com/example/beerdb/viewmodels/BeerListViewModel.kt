package com.example.beerdb.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerdb.models.BeerModel
import com.example.beerdb.repositories.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(private val beerRepository: BeerRepository) :
    ViewModel() {

    fun getBeers(): MutableLiveData<List<BeerModel>?> {
        return beerRepository.getBeers()
    }

    fun searchBeers(query: String) {
        Log.d("Beer ViewModel", "Inside searchBeers")
        beerRepository.searchBeers(query)
    }
}