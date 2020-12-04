package digitalhouse.desafio.modulo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setContentView(R.layout.activity_home)
        rv_comics.adapter = CardapioAdapter(listCardapios(), this)
        rv_comics.layoutManager = GridLayoutManager (this, 2)
    }
}