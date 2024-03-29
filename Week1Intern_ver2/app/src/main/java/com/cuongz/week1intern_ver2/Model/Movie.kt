package com.cuongz.week1intern_ver2.Model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie() : Parcelable {

    @SerializedName("vote_count")
    @Expose
    private var voteCount: Int? = null

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("video")
    @Expose
    private var video: Boolean? = null

    @SerializedName("vote_average")
    @Expose
    private var voteAverage: Double? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("popularity")
    @Expose
    private var popularity: Double? = null

    @SerializedName("poster_path")
    @Expose
    private var posterPath: String? = null

    @SerializedName("original_language")
    @Expose
    private var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    private var originalTitle: String? = null

    @SerializedName("genre_ids")
    @Expose
    private var genreIds: List<Int>? = null

    @SerializedName("backdrop_path")
    @Expose
    private var backdropPath: String? = null

    @SerializedName("adult")
    @Expose
    private var adult: Boolean? = null

    @SerializedName("overview")
    @Expose
    private var overview: String? = null

    @SerializedName("release_date")
    @Expose
    private var releaseDate: String? = null

    constructor(parcel: Parcel) : this() {
        voteCount = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        video = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        voteAverage = parcel.readValue(Double::class.java.classLoader) as? Double
        title = parcel.readString()
        popularity = parcel.readValue(Double::class.java.classLoader) as? Double
        posterPath = parcel.readString()
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        backdropPath = parcel.readString()
        adult = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        overview = parcel.readString()
        releaseDate = parcel.readString()
    }

    fun getId(): Int? {
        return id
    }

    fun getVoteAverage(): Double? {
        return voteAverage
    }

    fun getTitle(): String? {
        return title
    }

    fun getPosterPath(): String? {
        return posterPath
    }

    fun getGenreIds(): List<Int>? {
        return genreIds
    }

    fun getBackdropPath(): String? {
        return backdropPath
    }

    fun getOverview(): String? {
        return overview
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(voteCount)
        parcel.writeValue(id)
        parcel.writeValue(video)
        parcel.writeValue(voteAverage)
        parcel.writeString(title)
        parcel.writeValue(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeValue(adult)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}