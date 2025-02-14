package com.example.doggy.retrofit

import com.example.doggy.apiService.DogApiServiceInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val baseURL = "https://dog.ceo/"

    val DogApiService: DogApiServiceInterface = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DogApiServiceInterface::class.java)

}