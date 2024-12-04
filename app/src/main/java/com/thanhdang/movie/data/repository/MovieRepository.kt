package com.thanhdang.movie.data.repository

import com.thanhdang.movie.data.datasource.remote.Movie
import com.thanhdang.movie.data.datasource.remote.MovieApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: MovieApiService) {

    fun getPopularMovies(apiKey: String, page: Int = 1): Flow<List<Movie>> = flow {
        try {
            val response = apiService.getPopularMovies(apiKey, page = page)
            emit(response.results) // Trả dữ liệu thành công
        } catch (e: Exception) {
            emit(emptyList()) // Trả danh sách rỗng trong trường hợp lỗi
        }
    }

    fun getMovieDetails(movieId: Int, apiKey: String): Flow<Movie> = flow {
        try {
            val response = apiService.getMovieDetails(movieId, apiKey)
            emit(response)
        } catch (e: Exception) {
            // Có thể emit dữ liệu mặc định hoặc log lỗi
        }
    }
}
