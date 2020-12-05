package com.example.marvelapp.service

import com.example.marvelapp.model.QuadrinhoRes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository{

    @GET("characters/1009610/comics")
    suspend fun getResults(
        @Query("offset")p0: Int,
        @Query("format")p1: String,
        @Query("formatType")p2: String,
        @Query("orderBy")p3: String,
        @Query("limit")p4: Int,
        @Query("ts") p5: String,
        @Query("apikey")p6: String,
        @Query("hash")p7: String
    ): QuadrinhoRes
}

const val urlApiMarvel = "https://gateway.marvel.com/v1/public/"

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)
