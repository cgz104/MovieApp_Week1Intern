package com.cuongz.week1intern_ver2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MovieTrailerResponse {
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("results")
    @Expose
    private var movieTrailers: List<MovieTrailer>? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getMovieTrailers(): List<MovieTrailer>? {
        return movieTrailers
    }

    fun setResults(movieTrailers: List<MovieTrailer>) {
        this.movieTrailers = movieTrailers
    }
}