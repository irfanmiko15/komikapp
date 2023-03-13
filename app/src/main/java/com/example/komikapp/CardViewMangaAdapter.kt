package com.example.myrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.komikapp.DetailScreen
import com.example.komikapp.Manga
import com.example.komikapp.R
import android.content.Intent
import org.w3c.dom.Text

class CardViewMangaAdapter(private val listManga: ArrayList<Manga>) : RecyclerView.Adapter<CardViewMangaAdapter.CardViewViewHolder>(){

    private lateinit var onItemClickCallback: CardViewMangaAdapter.OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: CardViewMangaAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvTitle: TextView = itemView.findViewById(R.id.title)
        var tvAuthor: TextView = itemView.findViewById(R.id.author)
        var tvViews: TextView = itemView.findViewById(R.id.views)
        var tvChapter: TextView = itemView.findViewById(R.id.chapter)
        var tvScore:TextView=itemView.findViewById(R.id.score)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_manga, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val manga = listManga[position]
        Glide.with(holder.itemView.context)
            .load(manga.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvAuthor.text = manga.author
        holder.tvTitle.text = manga.title
        holder.tvViews.text=manga.countView
        holder.tvChapter.text=manga.chapter
        holder.tvScore.text=manga.score
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listManga[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listManga.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Manga)
    }
}