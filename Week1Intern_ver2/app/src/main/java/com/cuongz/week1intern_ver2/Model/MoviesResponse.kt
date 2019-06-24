package com.cuongz.week1intern_ver2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoviesResponse {

    @SerializedName("results")
    @Expose
    private var results: List<Movie>? = null

    fun getMovies(): List<Movie>? {
        return results
    }

}