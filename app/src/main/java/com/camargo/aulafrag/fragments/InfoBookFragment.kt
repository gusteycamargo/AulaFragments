package com.camargo.aulafrag.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.camargo.aulafrag.R
import com.camargo.aulafrag.adapters.ChapterAdapter
import com.camargo.aulafrag.model.Book
import kotlinx.android.synthetic.main.fragment_info_book.*

class InfoBookFragment : Fragment() {
    private lateinit var adapter: ChapterAdapter
    private lateinit var book: Book

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_book, container, false)
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        adapter = ChapterAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        book = arguments?.getSerializable("book") as Book

        t_title.text = book.title
        t_author.text = book.author
        t_publishing.text = book.publishingCompany
        t_year.text = book.year.toString()
        t_edition.text = book.edition.toString()
        adapter.updateList(book.chapters.toMutableList())

    }
}
