package digitalhouse.desafio.modulo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import digitalhouse.desafio.modulo3.Serialized.Comic
import digitalhouse.desafio.modulo3.Serialized.Data
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), HomeAdapter.OnClickItemListener {

    var listHQs = ArrayList<Comic>()
    lateinit var homeAdapter: HomeAdapter

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
        setContentView(R.layout.activity_home)

        homeAdapter = HomeAdapter(listHQs, this)
        rv_hqs.adapter = homeAdapter
        rv_hqs.layoutManager = GridLayoutManager(this, 2)
        rv_hqs.setHasFixedSize(true)

        viewModel.getHQs()

        Log.i("Lista ta pegando?", listHQs.toString())
    }

    override fun OnClickItem(position: Int) {
        val hq = listHQs[position]
        val intent = Intent(this, DetailsComics::class.java)
        intent.putExtra("hq", hq.id)
        startActivity(intent)
    }
}