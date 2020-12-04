package digitalhouse.desafio.modulo3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import digitalhouse.desafio.modulo3.Serialized.Comic
import kotlinx.android.synthetic.main.item_hq.view.*


class HomeAdapter(val hqs: ArrayList<Comic>, val listener: OnClickItemListener) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val ivComics: ImageView = itemView.img_comics
        val tvComics: TextView = itemView.tv_comics

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.OnClickItem(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val comic = hqs[position]

        holder.tvComics.text = "#${comic.id}"
        Glide.with(holder.ivComics.context).asBitmap()
            .load(comic.image.toString())
            .into(holder.ivComics)

    }

    override fun getItemCount() = hqs.size

    interface OnClickItemListener {
        fun OnClickItem(position: Int)
    }
}