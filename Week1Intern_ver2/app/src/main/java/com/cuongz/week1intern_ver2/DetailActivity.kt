package com.cuongz.week1intern_ver2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuongz.week1intern_ver2.Model.Movie
import com.cuongz.week1intern_ver2.PopularMovies.InterfacePopular
import com.cuongz.week1intern_ver2.PopularMovies.MovieTrailerPresenter
import kotlinx.android.synthetic.main.activity_inside_item.*

class DetailActivity : AppCompatActivity(), InterfacePopular.Trailer {

    private var trailerPresenter = MovieTrailerPresenter(this)
    private var keyYoutube: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_item)


        intent

        val objectMovie = intent.getParcelableExtra<Movie>("object")

        val movieID = objectMovie.getId()
        if (movieID != null) {
            trailerPresenter.getMovieTrailer(movieID)
        }



        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${objectMovie.getBackdropPath()}")
            .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
            .into(backdropMovie)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${objectMovie.getPosterPath()}")
            .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
            .into(posterMovie)


        mvOverview.text = objectMovie.getOverview()
        mvTitle.text = objectMovie.getTitle()

        trailerMovie.setOnClickListener { v ->
            val loadingToast = Toast.makeText(v?.context, "Loading", Toast.LENGTH_SHORT)
            loadingToast.show()
            Handler().postDelayed({
                loadingToast.cancel()
                Log.w("keyintent", "$keyYoutube")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:${keyYoutube}"))
                v?.context?.startActivity(intent)
            }, 1000)
        }


    }

    override fun onSuccessTrailer(key: String?) {
        keyYoutube = key
    }

    override fun onFailureTrailer() {

    }

}
