package com.example.desafiowebservice.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservice.entities.Comic
import com.example.desafiowebservice.entities.Data
import com.example.desafiowebservice.services.ServiceMarvelAPI
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest

class HomeViewModel(val marvelAPI: ServiceMarvelAPI) : ViewModel() {

    val listComics = MutableLiveData<Data>()
    val pubKey = "76c3653804591bc119feb8a8bced8a2a"
    val privKey = "c66e227de4893ad4b2d2c1578517b83a87d9c606"
    val ts = System.currentTimeMillis()

    fun getComics() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = marvelAPI.getResults(
                offset = 1,
                limit = 20,
                ts = ts,
                apiKey = pubKey,
                hash = getHash(ts.toString() + privKey + pubKey)
            ).get("data")
            val result = Gson().fromJson(
                response,
                object : TypeToken<Data>() {}.type
            ) as Data
            listComics.value = result
            Log.i("resultado_api", listComics.value.toString())
        }
    }

    fun getHash(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}