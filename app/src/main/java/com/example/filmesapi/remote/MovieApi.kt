package com.example.filmesapi.remote

import com.example.filmesapi.data.model.MarvelResponse
import retrofit2.http.GET

interface MovieApi {

    @GET("saga")
    suspend fun getAllMovies() : MarvelResponse
}