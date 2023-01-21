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
import com.arroyan.senengmovie9.adapters.TvShowAdapter

class TvShowFragment : Fragment() {

    private lateinit var adapter: TvShowAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvShowArrayList: ArrayList<Data>

    lateinit var name: Array<String>
    lateinit var detail: Array<String>
    lateinit var poster: Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_tvshow)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = TvShowAdapter(tvShowArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        tvShowArrayList = arrayListOf<Data>()

        name = arrayOf(
            getString(R.string.tvshow_name_1),
            getString(R.string.tvshow_name_2),
            getString(R.string.tvshow_name_3),
            getString(R.string.tvshow_name_4),
            getString(R.string.tvshow_name_5),
            getString(R.string.tvshow_name_6)
        )

        detail = arrayOf(
            getString(R.string.tvshow_detail_1),
            getString(R.string.tvshow_detail_2),
            getString(R.string.tvshow_detail_3),
            getString(R.string.tvshow_detail_4),
            getString(R.string.tvshow_detail_5),
            getString(R.string.tvshow_detail_6)
        )

        poster = arrayOf(
            R.drawable.tvshow1,
            R.drawable.tvshow2,
            R.drawable.tvshow3,
            R.drawable.tvshow4,
            R.drawable.tvshow5,
            R.drawable.tvshow6
        )

        for (i in name.indices) {
            val tvshow = Data(name[i], detail[i], poster[i])
            tvShowArrayList.add(tvshow)
        }
    }
}