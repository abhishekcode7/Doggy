package com.example.doggy.viewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doggy.dataClasses.DogData
import com.example.doggy.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenerateDogViewModel : ViewModel() {

    private val _dogLiveData = MutableLiveData<DogData>()
    val dogLiveData = _dogLiveData

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, e ->
        println(e.message)
    }

    /*
        Skipping creating repository because of single API call
     */

    fun fetchDogImage() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val dogData = RetrofitClient.DogApiService.getDogImage()
            _dogLiveData.postValue(dogData)
        }
    }
}