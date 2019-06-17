package com.cuongz.week1intern_ver2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Youtube {
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("size")
    @Expose
    private var size: String? = null
    @SerializedName("source")
    @Expose
    private var source: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getSize(): String? {
        return size
    }

    fun setSize(size: String) {
        this.size = size
    }

    fun getSource(): String? {
        return source
    }

    fun setSource(source: String) {
        this.source = source
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }
}