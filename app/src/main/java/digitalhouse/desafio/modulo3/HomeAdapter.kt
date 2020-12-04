package digitalhouse.desafio.modulo3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import digitalhouse.desafio.modulo3.Serialized.Comic



class HomeAdapter () :RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var listComics = arrayListOf<Comic>()

    class HomeViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ivComics : ImageView = itemView.iv_
        val tvComics : TextView = itemView.tvComics
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val comic = listComics.get(position)

        holder.tvComics.text = "#$comic.id"
        Glide.with(holder.ivComics.context).asBitmap()
            .load(comic.image.toString())
            .into(holder.ivComics)

    }

    override fun getItemCount() = listComics.size

    fun addComic(list: ArrayList<Comic>){
        listComics.addAll(list)
        notifyDataSetChanged()
    }
}