package com.camargo.aulafrag.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.camargo.aulafrag.R
import com.camargo.aulafrag.adapters.ChapterAdapter
import com.camargo.aulafrag.api.ChapterService
import com.camargo.aulafrag.model.Chapter
import kotlinx.android.synthetic.main.fragment_info_book.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoBookFragment : Fragment() {
    private lateinit var adapter: ChapterAdapter
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.3.2:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(ChapterService::class.java)
    private var bookId: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookId = arguments?.getInt("bookId")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_book, container, false)
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        adapter = ChapterAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        service.getById(bookId!!).enqueue(object : Callback<Chapter> {
            override fun onFailure(call: Call<Chapter>, t: Throwable) {
            }


            override fun onResponse(call: Call<Chapter>, response: Response<Chapter>) {
                adapter.updateList(response.body()!!.chapters.toMutableList())
            }

        })

    }
}
