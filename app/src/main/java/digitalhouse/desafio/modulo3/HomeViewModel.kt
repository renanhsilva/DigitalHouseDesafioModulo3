package digitalhouse.desafio.modulo3

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import digitalhouse.desafio.modulo3.Serialized.Comic
import digitalhouse.desafio.modulo3.Serialized.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.math.BigInteger
import java.security.MessageDigest


class HomeViewModel(val marvelApi: ServiceAPI) : ViewModel() {

    val listComics = MutableLiveData<ArrayList<Comic>>()
    val pubKey = "76c3653804591bc119feb8a8bced8a2a"
    val privKey = "c66e227de4893ad4b2d2c1578517b83a87d9c606"
    val ts = System.currentTimeMillis()

    fun getHQs() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = marvelApi.getResults(
                offset = 1,
                limit = 20,
                ts = ts,
                apiKey = pubKey,
                hash = getHash(ts.toString() + privKey + pubKey)
            ).get("data")
            val result = Gson().fromJson(response, object : TypeToken<Data>() {}.type) as Data
            listComics.value = result.results
            Log.i("resultado_api", listComics.value.toString())
        }
    }

    fun getHash(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}