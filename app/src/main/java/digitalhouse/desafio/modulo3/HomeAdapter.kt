package com.example.desafiowebservice.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import digitalhouse.desafio.modulo3.R


class ComicAdapter () :RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    var listComics = arrayListOf<Comic>()

    class ComicViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ivComics : ImageView = itemView.img_comics
        val tvComics : TextView = itemView.tv_comics
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return ComicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
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