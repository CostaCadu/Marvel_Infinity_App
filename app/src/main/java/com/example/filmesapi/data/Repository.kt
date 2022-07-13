package com.example.filmesapi.data

import android.util.Log
import com.example.filmesapi.data.model.MarvelResponseItem
import com.example.filmesapi.remote.NetworkConfig

class Repository {
    private val movieApi = NetworkConfig().getInstance()

    suspend fun getAllMovies(): List<MarvelResponseItem> {
        val list = movieApi.getAllMovies()
        Log.d("**Qualquer",list.toString() )
        return list
    }
}