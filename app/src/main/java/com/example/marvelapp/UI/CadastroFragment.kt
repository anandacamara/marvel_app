package com.example.marvelapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelapp.R
import kotlinx.android.synthetic.main.activity_login.*

class CadastroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
        toolbar_login_activity
    }

    companion object {
        fun newInstance() = CadastroFragment()
    }
}