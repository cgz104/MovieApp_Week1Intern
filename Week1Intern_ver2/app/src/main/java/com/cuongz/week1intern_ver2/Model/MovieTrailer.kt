package com.cuongz.week1intern_ver2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MovieTrailer {
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("quicktime")
    @Expose
    private var quicktime: List<Any>? = null
    @SerializedName("youtube")
    @Expose
    private var youtube: List<Youtube>? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getQuicktime(): List<Any>? {
        return quicktime
    }

    fun setQuicktime(quicktime: List<Any>) {
        this.quicktime = quicktime
    }

    fun getYoutube(): List<Youtube>? {
        return youtube
    }

    fun setYoutube(youtube: List<Youtube>) {
        this.youtube = youtube
    }
}