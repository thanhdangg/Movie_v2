package com.thanhdang.movie.presentation.ui.main

import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhdang.movie.R
import com.thanhdang.movie.data.datasource.remote.Movie

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.findViewById<ImageView>(R.id.imageView).apply {
                // Load image here
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
                    .centerCrop()
                    .placeholder(R.drawable.iv_example)
                    .into(this)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}
