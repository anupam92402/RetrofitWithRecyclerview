package com.example.retrofitwithrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithrecyclerview.R
import com.example.retrofitwithrecyclerview.models.Photos
import com.squareup.picasso.Picasso

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var photos = mutableListOf<Photos>()

    fun setMovieList(photos: List<Photos>) {
        this.photos = photos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sample_photos_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentPhoto = photos[position]
        holder.title.text = currentPhoto.title
        Picasso.get().load(currentPhoto.thumbnailUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.TVTitle)
    val image: ImageView = itemView.findViewById(R.id.IVImage)
}