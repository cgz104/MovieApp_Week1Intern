package com.cuongz.week1intern_ver2.PopularMovies

import com.cuongz.week1intern_ver2.Model.Movie

interface InterfacePopular {

    interface View{
        fun setPresenter(presenter: Presenter)

        fun onSuccess(listMovie: List<Movie>?)

        fun onFailure()
    }

    interface Presenter{
        fun getPopularMovie(page: Int = 1)

    }


}