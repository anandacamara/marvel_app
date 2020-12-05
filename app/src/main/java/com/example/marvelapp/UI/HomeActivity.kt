package com.example.marvelapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.QuadrinhoAdapter
import com.example.marvelapp.service.repository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), QuadrinhoAdapter.OnClickQuadrinho {
    lateinit var quadrinhoAdapter: QuadrinhoAdapter
    lateinit var gridLayoutManager: GridLayoutManager

    val viewModel by viewModels<HomeViewModel>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        quadrinhoAdapter = QuadrinhoAdapter(this, this)
        gridLayoutManager = GridLayoutManager(this, 3)
        rv_capas_quadrinhos.adapter = quadrinhoAdapter
        rv_capas_quadrinhos.layoutManager = gridLayoutManager
        rv_capas_quadrinhos.hasFixedSize()

        viewModel.popListResult()

        viewModel.listResults.observe(this) {
            quadrinhoAdapter.addQuadrinhos(it.data.results)
        }
        setScroller()
    }

    fun setScroller(){
        rv_capas_quadrinhos.addOnScrollListener(object : RecyclerView.OnScrollListener(){
        })
    }

    override fun onClickQuadrinho(position: Int) {
        val quadrinho = quadrinhoAdapter.listQuadrinhos[position]

        startActivity(
            Intent(this, DescricaoActivity::class.java).apply {
                putExtra("url_image", quadrinho.thumbnail.getURL())
                putExtra("titulo", quadrinho.title)
                putExtra("descricao", quadrinho.description)
                putExtra("data", quadrinho.modified)
                putExtra("preco", quadrinho.price.toString())
                putExtra("paginas", quadrinho.pageCount.toString())
            }
        )
    }
}