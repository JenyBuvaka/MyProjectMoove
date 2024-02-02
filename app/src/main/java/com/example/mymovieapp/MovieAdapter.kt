package com.example.mymovieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val clickListener: OnMovieClickListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    val movieList = ArrayList<MovieItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val container =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(container)//СОздается элемент
    }

    override fun getItemCount(): Int {//Размер массива
        return movieList.size
    }

    //Заполняем элемент
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie:MovieItem = movieList[position]
        holder.binding(movieList[position])
        holder.itemView.setOnClickListener { clickListener.setOnClick(movie) }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fragment = view.findViewById<ConstraintLayout>(R.id.movie)
        val bundle = Bundle()
        fun binding(item: MovieItem) {
            fragment.findViewById<ImageView>(R.id.tooltip_image)
                .setBackgroundResource(item.tooltipImage)
            fragment.findViewById<TextView>(R.id.img_age).setText(item.imgAge)
            fragment.findViewById<TextView>(R.id.reviews).setText(item.reviews)
            fragment.findViewById<TextView>(R.id.genre).setText(item.genre)
            fragment.findViewById<TextView>(R.id.title).setText(item.title)
            fragment.findViewById<TextView>(R.id.film_duration).setText(item.filmDuration)
        }
    }

    fun addMovie(movie: MovieItem) {//функция для обновления и добавление элементов
        movieList.add(movie)
        notifyDataSetChanged()
    }
}

data class MovieItem(
    var tooltipImage: Int = R.drawable.movie_avangers_movie_list,
    var imgAge: String = "",
    var reviews: String = "",
    var genre: String = "",
    var title: String = "",
    var filmDuration: String = "",
)