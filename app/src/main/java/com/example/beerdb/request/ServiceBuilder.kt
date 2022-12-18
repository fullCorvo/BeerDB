package com.example.beerdb.request

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    const val baseUrl = "https://api.punkapi.com/v2/"

    //CREATE HTTP CLIENT
    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit instance
    private val retrofit = builder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Beer service Interface
    fun <T> buildService (serviceType : Class<T>) : T {
        return retrofit.create(serviceType)
    }
}