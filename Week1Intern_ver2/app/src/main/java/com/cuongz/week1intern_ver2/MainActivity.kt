package com.cuongz.week1intern_ver2

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.cuongz.week1intern_ver2.Model.Movie
import com.cuongz.week1intern_ver2.PopularMovies.InterfacePopular
import com.cuongz.week1intern_ver2.PopularMovies.PopularAdapter
import com.cuongz.week1intern_ver2.PopularMovies.PopularPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InterfacePopular.View {

    private var presenter: InterfacePopular.Presenter = PopularPresenter(this)
    private var adapter: PopularAdapter? = null
    private var page = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getPopularMovie(page)

        goLeft.setOnClickListener { v ->
            if(page != 1){
                page--
                presenter.getPopularMovie(page)
                val loadingToast = Toast.makeText(v?.context, "Loading", Toast.LENGTH_LONG)
                loadingToast.show()
                Handler().postDelayed({ loadingToast.cancel() }, 1000)

            }
        }

        goRight.setOnClickListener { v ->
            page++
            presenter.getPopularMovie(page)
            val loadingToast = Toast.makeText(v?.context, "Loading", Toast.LENGTH_LONG)
            loadingToast.show()
            Handler().postDelayed({ loadingToast.cancel() }, 1000)
        }

        swipeContainer.setOnRefreshListener { fetchTimelineAsync(page) }

    }

    private fun fetchTimelineAsync(_page: Int){
        presenter.getPopularMovie(_page + 1)
        page++
        swipeContainer.isRefreshing = false
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
