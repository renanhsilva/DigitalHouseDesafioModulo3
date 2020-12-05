package digitalhouse.desafio.modulo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import digitalhouse.desafio.modulo3.Serialized.Comic
import kotlinx.android.synthetic.main.activity_zoom_imagem.*

class ZoomImagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_imagem)
        setSupportActionBar(bc_zoom_imagem)

        val hq = intent.getSerializableExtra("hq") as Comic

        if (hq.images.isNullOrEmpty()){
            img_cover_zoom.setImageResource(R.drawable.marvel_logo)
        } else {
            Glide.with(this).asBitmap()
                .load(hq.images.first().toString())
                .into(img_cover_zoom)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}