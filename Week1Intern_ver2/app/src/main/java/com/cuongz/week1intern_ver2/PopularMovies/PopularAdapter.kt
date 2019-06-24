package com.cuongz.week1intern_ver2.PopularMovies

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuongz.week1intern_ver2.DetailActivity
import com.cuongz.week1intern_ver2.Model.Genres
import com.cuongz.week1intern_ver2.Model.Movie
import com.cuongz.week1intern_ver2.R


class PopularAdapter(private var listMovie: List<Movie>): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_movie, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(listMovie[p1])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var poster = itemView.findViewById(R.id.poster) as ImageView
        private var title = itemView.findViewById(R.id.title) as TextView
        private var date = itemView.findViewById(R.id.date) as TextView
        private var rating = itemView.findViewById(R.id.rating) as TextView
        private var genre = itemView.findViewById(R.id.genre) as TextView


        fun bind(movie: Movie){
            title.text = movie.getTitle()
            date.text = movie.getReleaseDate()
            rating.text = movie.getVoteAverage().toString()
            genre.text = Genres.getGenre(movie.getGenreIds())
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${movie.getPosterPath()}")
                .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                .into(poster)



            itemView.setOnClickListener { v ->
                //                    trailerPresenter.getMovieTrailer(movie.getId()!!)
                //                    Toast.makeText(itemView.context, "testing", Toast.LENGTH_SHORT).show()
                //                    getKey(movie)
                //
                //                    Handler().postDelayed(object: Runnable{
                //                        override fun run() {
                //                            Log.w("keyintent", "$keyToYoutube")
                //                            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:${keyToYoutube}"))
                //                            startActivity(itemView.context, intent, null)
                //                        }
                //                    }, 5000)
                val intent = Intent(v?.context,DetailActivity::class.java)

                intent.putExtra("object", movie)
                v?.context?.startActivity(intent)
            }
        }
//        fun getKey(movie: Movie){
//            var trailerPresenter = MovieTrailerPresenter()
//            var key: String? = null
//            trailerPresenter.getMovieTrailer(movie.getId()!!)
//            Handler().postDelayed(object: Runnable{
//                override fun run() {
//
//                    keyToYoutube = trailerPresenter.getKeyFromApi()
//                    Log.w("key1234", "$keyToYoutube")
//
//                }
//            }, 3000)
//
//
//        }

    }

}

