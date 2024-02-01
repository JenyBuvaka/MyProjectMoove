package com.example.mymovieapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var spanCount: Int = 2
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var intent: Intent

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSpanCount()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, spanCount)

        val itemList: List<MovieItem> = listOf(
            MovieItem(
                imgAge = getString(R.string.age_limit_movie_details),
                reviews = getString(R.string.rewiews),
                genre = getString(R.string.genre_movie_details),
                title = getString(R.string.title_movie_AVG),
                filmDuration = getString(R.string.film_duration)
            ),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(),
            MovieItem(
                imgAge = getString(R.string.age_limit_movie_details),
                reviews = getString(R.string.rewiews),
                genre = getString(R.string.genre_movie_details),
                title = getString(R.string.title_movie_AVG),
                filmDuration = getString(R.string.film_duration)
            )
        )
        adapter = MovieAdapter(object : OnMovieClickListener {
            override fun setOnClick(position: Int) {
                intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
                startActivity(intent)
            }
        })

        itemList.forEach { adapter.addMovie(it) }

        recyclerView.adapter = adapter
    }

    private fun setSpanCount() {
        val config = resources.configuration
        if (config.orientation == ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setSpanCount()

        // Обновите LayoutManager и перерисуйте recyclerView
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, spanCount)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
