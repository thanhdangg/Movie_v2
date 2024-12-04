package com.thanhdang.movie.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.thanhdang.movie.data.repository.MovieRepository
import com.thanhdang.movie.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        lifecycleScope.launchWhenStarted {
            movieViewModel.popularMovies.collect { movies ->
                // Hiển thị danh sách phim
                binding.rvPopular.apply {
                    adapter = MovieAdapter(movies)
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            movieViewModel.loadingState.collect { isLoading ->
                binding.progressBar.visibility = if (isLoading) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
        movieViewModel.fetchPopularMovies(API_KEY)

    }
    companion object {
        private const val API_KEY = "52fd990cf637355f51d3eea6bc930bba"
    }
}