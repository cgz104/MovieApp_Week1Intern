package com.cuongz.week1intern_ver2.Model

object Genres {
    val listGenre = arrayOf(
        arrayOf(28, "Action"),
        arrayOf(12, "Adventure"),
        arrayOf(16, "Animation"),
        arrayOf(35, "Comedy"),
        arrayOf(80, "Crime"),
        arrayOf(99, "Documentary"),
        arrayOf(18, "Drama"),
        arrayOf(10751, "Family"),
        arrayOf(36, "History"),
        arrayOf(14, "Fantasy"),
        arrayOf(27, "Horror"),
        arrayOf(10402, "Music"),
        arrayOf(9648, "Mystery"),
        arrayOf(10749, "Romance"),
        arrayOf(878, "Science Fiction"),
        arrayOf(10770, "TV Movie"),
        arrayOf(53, "Thriller"),
        arrayOf(10752, "War"),
        arrayOf(37, "Western")
    )

    fun getGenre(list: List<Int>?): String? {
        var genre: String? = null
        if (list == null) return null
        for (i in list){
            for (j in listGenre){
                if (i == j[0]){
                    if(genre == null){
                        genre = j[1].toString()
                    }else genre = genre + ", " + j[1]
                    continue
                }
            }
        }
        return genre
    }

}