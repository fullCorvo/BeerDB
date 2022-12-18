package com.example.beerdb.request

import com.example.beerdb.models.BeerModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApi {

    companion object{
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }


    //Queries to communicate with the Rest Api PUNK API

    @GET("beers")
    fun searchBeer (@Query("beer_name") query: String) : Call<List<BeerModel>>

    @GET("beers")
    fun getBeersFromId (@Query("ids") query: String) : Call<List<BeerModel>>
}