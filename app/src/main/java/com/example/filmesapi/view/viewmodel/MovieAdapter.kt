package com.example.filmesapi.view.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmesapi.data.model.MarvelResponseItem
import com.example.filmesapi.databinding.ActivityMainBinding
import com.example.filmesapi.databinding.ActivityMainBinding.inflate
import com.example.filmesapi.databinding.MovieItemBinding
import com.example.filmesapi.databinding.MovieItemBinding.inflate

class MovieAdapter(
     val lista: List<MarvelResponseItem> )
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = lista[position].title
            tvGender.text = lista[position].genre
            tvDescription.text = lista[position].released

            Glide.with(holder.itemView)
                .load(lista[position].poster)
                .into(ivPoster)
        }
    }

    override fun getItemCount() = lista.size

}

class MovieViewHolder( val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)