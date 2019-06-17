package com.cuongz.week1intern_ver2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoviesResponse {
    @SerializedName("page")
    @Expose
    private var page: Int = 0

    @SerializedName("total_results")
    @Expose
    private var totalResults: Int = 0

    @SerializedName("results")
    @Expose
    private var results: List<Movie>? = null

    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int = 0

    fun getPage(): Int {
        return page
    }

    fun setPage(page: Int) {
        this.page = page
    }

    fun getTotalResults(): Int {
        return totalResults
    }

    fun setTotalResults(totalResults: Int) {
        this.totalResults = totalResults
    }

    fun getMovies(): List<Movie>? {
        return results
    }

    fun setMovies(movies: List<Movie>) {
        this.results = movies
    }

    fun getTotalPages(): Int {
        return totalPages
    }

    fun setTotalPages(totalPages: Int) {
        this.totalPages = totalPages
    }
}