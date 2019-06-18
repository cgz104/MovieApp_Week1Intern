package com.cuongz.week1intern_ver2.PopularMovies

import android.os.Handler
import android.util.Log
import com.cuongz.week1intern_ver2.Api.Api
import com.cuongz.week1intern_ver2.Model.MovieTrailerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieTrailerPresenter : InterfacePopular.TrailerPresenter {
    private var key : String? = null
    override fun getMovieTrailer(id: Int) {
        Api.createService().getTrailer(id).enqueue(object : Callback<MovieTrailerResponse> {
            override fun onFailure(call: Call<MovieTrailerResponse>, t: Throwable) {
                Log.w("test1", "sdfsdf")
            }
            override fun onResponse(call: Call<MovieTrailerResponse>, response: Response<MovieTrailerResponse>) {
                if(response.body() != null){
                    key = response.body()?.getMovieTrailers()?.get(0)?.key
                    Log.w("asdf", "$key")
                }
            }

        })
    }
    fun getKeyFromApi(): String?{
        return this.key
    }

}