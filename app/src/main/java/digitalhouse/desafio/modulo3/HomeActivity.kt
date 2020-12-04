package digitalhouse.desafio.modulo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

class HomeActivity : AppCompatActivity() {

    lateinit var homeAdapter : HomeAdapter

    val viewModel by viewModels<HomeViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(marvelApi) as T
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setContentView(R.layout.activity_home)
        homeAdapter = HomeAdapter()
        rv_hqs.adapter = homeAdapter
        rv_hqs.layoutManager = GridLayoutManager(this,3)
        rv_hqs.setHasFixedSize(true)

        viewModel.getComics()
    }
}