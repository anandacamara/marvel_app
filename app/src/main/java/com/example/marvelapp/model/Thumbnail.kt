package com.example.marvelapp.model

class Thumbnail(val path: String?, val extension: String?) {

    fun getURL(): String{
        var url = "${path}.${extension}"
        return url.replace("http", "https")
    }
}