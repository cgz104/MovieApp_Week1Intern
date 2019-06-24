package com.cuongz.week1intern_ver2.PopularMovies

import com.cuongz.week1intern_ver2.Api.Api
import com.cuongz.week1intern_ver2.Model.MovieTrailerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieTrailerPresenter(val trailer: InterfacePopular.Trailer) : InterfacePopular.TrailerPresenter {
//    private var key : String? = null
    override fun getMovieTrailer(id: Int) {
        Api.createService().getTrailer(id).enqueue(object : Callback<MovieTrailerResponse> {
            override fun onFailure(call: Call<MovieTrailerResponse>, t: Throwable) {
//                Log.w("test1", "sdfsdf")
            }
            override fun onResponse(call: Call<MovieTrailerResponse>, response: Response<MovieTrailerResponse>) {
                if(response.body() != null){
//                    key = response.body()?.getMovieTrailers()?.get(0)?.key
//                    Log.w("asdf", "$key")
                    trailer.onSuccessTrailer(response.body()?.getMovieTrailers()?.get(0)?.key)

                }
            }

        })
    }
//    fun getKeyFromApi(): String?{
//        return this.key
//    }

}