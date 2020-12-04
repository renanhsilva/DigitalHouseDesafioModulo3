package digitalhouse.desafio.modulo3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import digitalhouse.desafio.modulo3.Serialized.Comic



class HomeAdapter (val hqs: ArrayList<Comic>, val listener: OnClickItemListener) :RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var listComics = ArrayList<Comic>()

    class HomeViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ivComics : ImageView = itemView.findViewById(R.id.img_comics)
        val tvComics : TextView = itemView.findViewById(R.id.tv_comics)

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

    interface OnClickItemListener {
        fun OnClickItem(position: Int)
    }
}