package com.example.marvelapp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R

class QuadrinhoAdapter(val listener: OnClickQuadrinho): RecyclerView.Adapter<QuadrinhoAdapter.QuadrinhoViewHolder>() {
    val listQuadrinhos = ArrayList<Quadrinho>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadrinhoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_quadrinhos_capa, parent, false)
        return QuadrinhoViewHolder(view)
    }

    override fun getItemCount(): Int = listQuadrinhos.size

    override fun onBindViewHolder(holder: QuadrinhoViewHolder, position: Int) {
        var aluno = listQuadrinhos[position]
        holder.numero.text = aluno.numero.toString()
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
        val imagem: ImageView = view.findViewById(R.id.iv_capa)

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onClickQuadrinho(position)
            }
        }
    }
}