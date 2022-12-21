package com.example.beerdb.request
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidTest
@RunWith(JUnit4::class)
class PunkApiClientTest {

    @Test
    fun testSearchBeersSuccess() {

        //Given
        val retrofit : Retrofit =
            Retrofit.Builder()
                .baseUrl(PunkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val punkApi = retrofit.create(PunkApi::class.java)
        val requestCall = punkApi.searchBeer("ipa")

        //When
        val response = requestCall.execute()

        //Then
        assert(response.isSuccessful)

    }

    @Test
    fun testSearchBeersError() {

        //Given
        val retrofit : Retrofit =
            Retrofit.Builder()
                .baseUrl(PunkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val punkApi = retrofit.create(PunkApi::class.java)
        val requestCall = punkApi.searchBeer("")

        //When
        val response = requestCall.execute()

        //Then
        assert(!response.isSuccessful)

    }
}