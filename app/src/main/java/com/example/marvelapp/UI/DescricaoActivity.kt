package com.example.marvelapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.example.marvelapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_descricao.*
import kotlinx.android.synthetic.main.layout_capa.*
import kotlinx.android.synthetic.main.layout_capa.view.*

class DescricaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descricao)

        val url_image = intent.getStringExtra("url_image")

        iv_capa.setOnClickListener { onClickCapa(url_image) }

        toolbar_descricao_activity.setNavigationOnClickListener { onBackPressed() }

        Picasso.with(this).load(url_image).into(iv_fundo_quadrinho)
        Picasso.with(this).load(url_image).into(iv_capa)

        tv_titulo.text = intent.getStringExtra("titulo")
        tv_descricao.text = intent.getStringExtra("descricao")
        data_publicacao.text = intent.getStringExtra("data")
        tv_preco.text = intent.getStringExtra("preco")
        tv_pages.text = intent.getStringExtra("paginas")
    }

     fun onClickCapa(url: String?) {
         val li: LayoutInflater = this.layoutInflater
         val view: View = li.inflate(R.layout.layout_capa, null)
         Picasso.with(this).load(url).into(view.iv_capa_extendida)

        run {
            MaterialAlertDialogBuilder(this)
                .setBackgroundInsetStart(70)
                .setBackgroundInsetEnd(70)
                .setBackgroundInsetTop(10)
                .setBackgroundInsetBottom(100)
                .setBackground(
                    ContextCompat.getColor(this, android.R.color.transparent).toDrawable()
                )
                .setView(view)
                .show()
        }
    }
}