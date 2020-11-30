package com.example.marvelapp.model

import java.io.Serializable

data class Quadrinho (val numero: Int,
                      val dataPublicacao: String,
                      val preco: Double,
                      val pages: Int,
                      val descricao: String): Serializable