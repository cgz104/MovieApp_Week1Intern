package com.cuongz.week1intern_ver2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.cuongz.week1intern_ver2.Model.Movie
import com.cuongz.week1intern_ver2.PopularMovies.InterfacePopular
import com.cuongz.week1intern_ver2.PopularMovies.PopularAdapter
import com.cuongz.week1intern_ver2.PopularMovies.PopularPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InterfacePopular.View {

    private var presenter: InterfacePopular.Presenter = PopularPresenter(this)
    private var adapter: PopularAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getPopularMovie()
    }

    override fun setPresenter(presenter: InterfacePopular.Presenter) {
        this.presenter = presenter
    }

    override fun onSuccess(listMovie: List<Movie>?) {
        if (listMovie == null) return
        adapter = PopularAdapter(listMovie)
        movies_list.adapter = adapter
        movies_list.layoutManager = LinearLayoutManager(this)
    }

    override fun onFailure() {

    }
}
