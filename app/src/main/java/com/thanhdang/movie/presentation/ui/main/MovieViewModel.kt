package com.thanhdang.movie.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.thanhdang.movie.data.repository.MovieRepository
import com.thanhdang.movie.data.datasource.remote.Movie

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _popularMovies = MutableStateFlow<List<Movie>>(emptyList())
    val popularMovies: StateFlow<List<Movie>> get() = _popularMovies

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> get() = _loadingState

    fun fetchPopularMovies(apiKey: String, page: Int = 1) {
        viewModelScope.launch {
            _loadingState.value = true
            repository.getPopularMovies(apiKey, page)
                .catch { e ->
                    // Xử lý lỗi, nếu cần'
                    _loadingState.value = false
                    _popularMovies.value = emptyList()
                }
                .collect { movies ->
                    _loadingState.value = false
                    _popularMovies.value = movies
                }
        }
    }
}
