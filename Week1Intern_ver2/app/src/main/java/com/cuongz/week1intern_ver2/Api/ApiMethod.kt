package com.cuongz.week1intern_ver2.Api

import com.cuongz.week1intern_ver2.Model.MovieTrailerResponse
import com.cuongz.week1intern_ver2.Model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiMethod {
    @GET("movie/popular")
    fun getPopular(
        @Query("page")
        page: Int = 1
    ): Call<MoviesResponse>

//    @GET("genre/movie/list")
//    fun getGenres(
//        @Query("movie_id") id: Int
//    ):Call<MovieTrailerResponse>

    @GET("movie/{movie_id}/videos")
    fun getTrailer(
        @Path("movie_id") id: Int
    ): Call<MovieTrailerResponse>
}