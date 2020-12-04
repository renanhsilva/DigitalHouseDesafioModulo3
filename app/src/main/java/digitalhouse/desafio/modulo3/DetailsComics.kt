package digitalhouse.desafio.modulo3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
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

//        val comicId: Int = intent.getIntExtra("hq", 0).toInt()
//
//        img_back.setOnClickListener { onBackPressed() }
//        try {
//            viewModel.getHQs()
//        } catch (e: Exception) {
//            Log.i(this.javaClass.name, e.message.toString())
//            Toast.makeText(this, "Failed to connect", Toast.LENGTH_LONG).show()
//        }

//        viewModel.hq.observe(this) {
//            hq = it
//            val comic = hq.results[0]
//            tv_title.text = comic.title
//
//            tv_description.text = comic.description
//
//            if (comic.pageCount != 0)
//                tv_pages.text = comic.pageCount.toString()
//            else tv_pages.text = "No data"
//
//            if (comic.prices[0].price != 0.0)
//                tv_price.text = comic.prices[0].price.toString()
//            else tv_price.text = "No data"
//
//            val jsDate = (comic.dates.find { s -> s.type == "focDate" })?.date.toString()
//            if (jsDate.toCharArray()[0] != '-') {
//                val javaDate: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse(jsDate)
//                val dateFmt = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
//                val date = dateFmt.format(javaDate)
//                tv_publish.text = date
//            } else tv_publish.text = "No data"

//            Glide.with(this)
//                .load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
//                .into(img_cover)
//
//            Glide.with(this)
//                .load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
//                .centerCrop()
//                .into(img_banner)
//        }
    }
}