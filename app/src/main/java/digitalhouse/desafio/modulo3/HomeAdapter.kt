package digitalhouse.desafio.modulo3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import digitalhouse.desafio.modulo3.Serialized.Comic
import kotlinx.android.synthetic.main.item_hq.view.*


class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var listComics = arrayListOf<Comic>()

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivComics: ImageView = itemView.img_comics
        val tvComics: TextView = itemView.tv_comics

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val hq = listComics[position]

        holder.tvComics.text = "#${hq.id}"

        if (hq.images.isNullOrEmpty()){
            holder.ivComics.setImageResource(R.drawable.marvel_logo)
        } else {
            Glide.with(holder.ivComics.context).asBitmap()
                .load(hq.images.first().toString())
                .into(holder.ivComics)
        }
        holder.ivComics.setOnClickListener{
            var intent = Intent(it.context,DetailsComics::class.java)
            intent.putExtra("hq", hq)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listComics.size

    fun addComic(list: ArrayList<Comic>){
        listComics.addAll(list)
        notifyDataSetChanged()
    }
}