package com.example.marvelapp.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.UI.HomeActivity
import com.google.gson.JsonArray
import com.squareup.picasso.Picasso

class QuadrinhoAdapter(val listener: OnClickQuadrinho, val context: HomeActivity): RecyclerView.Adapter<QuadrinhoAdapter.QuadrinhoViewHolder>() {
    val listQuadrinhos = ArrayList<Quadrinho>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadrinhoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_quadrinhos_capa, parent, false)
        return QuadrinhoViewHolder(view)
    }

    override fun getItemCount(): Int = listQuadrinhos.size

    override fun onBindViewHolder(holder: QuadrinhoViewHolder, position: Int) {
        var quadrinho = listQuadrinhos[position]
        holder.numero.text = "#${quadrinho.issueNumber}"

        val url = "${quadrinho.thumbnail?.path}.${quadrinho.thumbnail?.extension}"

        Picasso.with(context).load("http://i.annihil.us/u/prod/marvel/i/mg/9/d0/5ae9bb4996a61.jpg").into(holder.imagem)

//        Glide
//            .with(context)
//            .load("http://i.annihil.us/u/prod/marvel/i/mg/9/d0/57b36fddc0776.jpg")
//            .into(holder.imagem)
    }

    fun addQuadrinhos(list: ArrayList<Quadrinho>){
        listQuadrinhos.addAll(list)
        notifyDataSetChanged()
    }

    interface OnClickQuadrinho{
        fun onClickQuadrinho(position: Int)
    }

    inner class QuadrinhoViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        val numero: TextView = view.findViewById(R.id.tv_numero)
        val imagem: ImageView = view.findViewById(R.id.iv_capa_quadrinho)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onClickQuadrinho(position)
            }
        }
    }
}