package com.cuongz.week1intern_ver2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MovieTrailerResponse {
    @SerializedName("results")
    @Expose
    private var movieTrailers: List<MovieTrailer>? = null

    fun getMovieTrailers(): List<MovieTrailer>? {
        return movieTrailers
    }

}