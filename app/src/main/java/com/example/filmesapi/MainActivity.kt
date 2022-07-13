package com.example.filmesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesapi.data.Repository
import com.example.filmesapi.databinding.ActivityMainBinding
import com.example.filmesapi.view.viewmodel.MovieAdapter
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        loadData()
        setContentView(binding.root)
    }
    private fun loadData(){
        lifecycleScope.launch{
            val dados = Repository().getAllMovies()
            recycler = binding.rvList
            with(recycler){
                layoutManager = GridLayoutManager(this@MainActivity,2)
                adapter = MovieAdapter(dados)
            }
        }
    }

}