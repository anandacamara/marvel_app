package com.example.marvelapp.UI

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.model.QuadrinhoRes
import com.example.marvelapp.service.Repository
import kotlinx.coroutines.launch

class HomeViewModel(val repository: Repository) : ViewModel() {

    val listResults = MutableLiveData<QuadrinhoRes>()

    fun popListResult() {
        viewModelScope.launch {
            val quadrinhos = repository.getResults(
                    1,
                "comic",
                "comic",
                "modified",
                100,
                "1",
                "c0d36509187d1fa7b5f098da6153dc30",
                "0f8969510ba4ae1d6458851995696c87"
            )
            listResults.value = quadrinhos
            Log.i("TAG", quadrinhos.data.results.toString())
        }
    }
}
