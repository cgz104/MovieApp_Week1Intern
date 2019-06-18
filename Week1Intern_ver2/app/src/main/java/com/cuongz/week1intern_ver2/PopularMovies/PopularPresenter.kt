package com.cuongz.week1intern_ver2.PopularMovies

import android.util.Log
import com.cuongz.week1intern_ver2.Api.Api
import com.cuongz.week1intern_ver2.Model.MovieTrailer
import com.cuongz.week1intern_ver2.Model.MovieTrailerResponse
import com.cuongz.week1intern_ver2.Model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PopularPresenter(val view: InterfacePopular.View): InterfacePopular.Presenter {
    override fun getPopularMovie(page: Int) {
        Api.createService().getPopular(page).enqueue(object : Callback<MoviesResponse>{
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                view.onFailure()
            }

            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if(response.body() != null){
                    view.onSuccess(response.body()?.getMovies())
                }
            }

        })
    }


}