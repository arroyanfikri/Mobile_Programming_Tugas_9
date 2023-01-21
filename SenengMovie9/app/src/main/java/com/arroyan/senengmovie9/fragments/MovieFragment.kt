package com.arroyan.senengmovie9.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arroyan.senengmovie9.Data
import com.arroyan.senengmovie9.R
import com.arroyan.senengmovie9.adapters.MovieAdapter

class MovieFragment : Fragment() {

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Data>

    lateinit var name: Array<String>
    lateinit var detail: Array<String>
    lateinit var poster : Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MovieAdapter(movieArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Data>()

        name = arrayOf(
            getString(R.string.movie_name_1),
            getString(R.string.movie_name_2),
            getString(R.string.movie_name_3),
            getString(R.string.movie_name_4),
            getString(R.string.movie_name_5),
            getString(R.string.movie_name_6)
        )

        detail = arrayOf(
            getString(R.string.movie_detail_1),
            getString(R.string.movie_detail_2),
            getString(R.string.movie_detail_3),
            getString(R.string.movie_detail_4),
            getString(R.string.movie_detail_5),
            getString(R.string.movie_detail_6)
        )

        poster = arrayOf(
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie6
        )

        for (i in name.indices) {
            val movie = Data(name[i], detail[i], poster[i])
            movieArrayList.add(movie)
        }
    }
}