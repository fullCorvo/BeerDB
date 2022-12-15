package com.example.beerdb.request

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.beerdb.models.BeerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PunkApiClient {

    // LiveData
    private var beerList : MutableLiveData<List<BeerModel>?> = MutableLiveData()

    fun getBeers() : MutableLiveData<List<BeerModel>?> {
        return beerList
    }

    fun searchBeers(query: String) {

        //initiate the service
        val destinationService = ServiceBuilder.buildService(PunkApi::class.java)
        val requestCall = destinationService.searchBeer(query)

        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<BeerModel>> {
            override fun onResponse(call: Call<List<BeerModel>>, response: Response<List<BeerModel>>) {

                if (response.isSuccessful){

                    val list = response.body()

                    beerList.value = list

                }

                else Log.d("Home ViewModel", "something went wrong")
            }

            override fun onFailure(call: Call<List<BeerModel>>, t: Throwable) {
                Log.d("Home ViewModel", "onFailure: call to api failed")
            }
        })
    }
}



















