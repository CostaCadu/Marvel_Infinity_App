package com.example.filmesapi.remote

import com.example.filmesapi.utils.Constants.BASE_URL
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {

    private fun provideRetrogfit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

  fun getInstance(): MovieApi{
      return provideRetrogfit().create(MovieApi::class.java)
  }
}