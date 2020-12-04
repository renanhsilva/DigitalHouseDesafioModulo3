package digitalhouse.desafio.modulo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import digitalhouse.desafio.modulo3.Serialized.Comic
import digitalhouse.desafio.modulo3.Serialized.Data
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(){

    lateinit var homeAdapter: HomeAdapter
    lateinit var gridLayoutManager: GridLayoutManager

    val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(marvelApi) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeAdapter = HomeAdapter()
        gridLayoutManager = GridLayoutManager(this,3)
        rv_hqs.adapter = homeAdapter
        rv_hqs.layoutManager = GridLayoutManager(this, 3)
        rv_hqs.hasFixedSize()

        viewModel.listComics.observe(this){
            homeAdapter.addComic(it)
        }

        viewModel.getHQs()

    }
}