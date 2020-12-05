package digitalhouse.desafio.modulo3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import digitalhouse.desafio.modulo3.Serialized.Comic
import kotlinx.android.synthetic.main.activity_details_comics.*
import java.text.SimpleDateFormat
import java.util.*

class DetailsComics : AppCompatActivity() {
    private lateinit var hq: ServiceAPI

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
        setContentView(R.layout.activity_details_comics)
        setSupportActionBar(tb_details_comics)

        val hq = intent.getSerializableExtra("hq") as Comic

            tv_title.text = hq.title
            tv_description.text = hq.description
            tv_publish.text = hq.dates.first().getComicDate()
            tv_price.text = hq.prices.first().toString()
            tv_pages.text = hq.pageCount.toString()

        if (hq.images.isNullOrEmpty()){
            img_banner.setImageResource(R.drawable.marvel_logo)
        } else {
            Glide.with(this).asBitmap()
                .load(hq.images.first().toString())
                .into(img_banner)
        }
        if (hq.images.isNullOrEmpty()){
            img_cover.setImageResource(R.drawable.marvel_logo)
        } else {
            Glide.with(this).asBitmap()
                .load(hq.images.first().toString())
                .into(img_cover)
        }

        img_banner.setOnClickListener {
            var intent = Intent(it.context,ZoomImagemActivity::class.java)
            intent.putExtra("hq",hq)
            it.context.startActivity(intent)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}