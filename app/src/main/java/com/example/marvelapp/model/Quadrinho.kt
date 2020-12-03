package com.example.marvelapp.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.Serializable

data class QuadrinhoRes(val data: Data)

data class Data(val offset: Int, var results: ArrayList<Quadrinho>)

data class Quadrinho (val issueNumber: Int,
                      val thumbnail: JsonObject,
                      val title: String,
                      val modified: String,
                      val price: Double,
                      val pageCount: Int,
                      val description: String): Serializable{
    val url: JsonArray = thumbnail.getAsJsonArray()
    val image = "${url[0]}.${url[1]}"
}