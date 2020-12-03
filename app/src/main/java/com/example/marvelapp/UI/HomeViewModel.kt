package com.example.marvelapp.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.model.Quadrinho
import com.example.marvelapp.service.Repository
import kotlinx.coroutines.launch

class HomeViewModel(val repository: Repository) : ViewModel() {

    val listResults = MutableLiveData<ArrayList<Quadrinho>>()

    fun popListResult() {
        viewModelScope.launch {
            repository.getResults(
                "comic",
                "comic",
                "modified",
                15,
                "1",
                "c0d36509187d1fa7b5f098da6153dc30",
                "0f8969510ba4ae1d6458851995696c87"
            ).toString()
        }
    }
}
