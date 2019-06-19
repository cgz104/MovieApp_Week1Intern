package com.cuongz.week1intern_ver2

import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.cuongz.week1intern_ver2.Model.Movie
import com.cuongz.week1intern_ver2.Model.MovieTrailer
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

        goLeft.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if(page != 1){
                    page--
                    presenter.getPopularMovie(page)
                    var loadingToast = Toast.makeText(v?.context, "Loading", Toast.LENGTH_LONG)
                    loadingToast.show()
                    Handler().postDelayed(object: Runnable{
                        override fun run() {
                            loadingToast.cancel()
                        }
                    }, 1000)

                }

            }
        })

        goRight.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                page++
                presenter.getPopularMovie(page)
                var loadingToast = Toast.makeText(v?.context, "Loading", Toast.LENGTH_LONG)
                loadingToast.show()
                Handler().postDelayed(object: Runnable{
                    override fun run() {
                        loadingToast.cancel()
                    }
                }, 1000)
            }
        })

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
