package com.example.marvelapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class QuadrinhoRes(val data: Data)

data class Data(val offset: Int, var results: ArrayList<Quadrinho>)

class Quadrinho(
    val issueNumber: Int,
    val thumbnail: Thumbnail,
    val title: String,
    val modified: String,
    val price: Double,
    val pageCount: Int,
    val description: String
) : Serializable{

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDataFormatada(): String {
       return LocalDateTime.parse(modified.split("-0400")[0]).format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))
    }
}