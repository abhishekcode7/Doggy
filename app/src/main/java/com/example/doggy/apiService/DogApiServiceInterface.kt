package com.example.doggy.apiService

import com.example.doggy.dataClasses.DogData
import retrofit2.http.GET

interface DogApiServiceInterface {

    @GET("api/breeds/image/random")
    suspend fun getDogImage(): DogData
}