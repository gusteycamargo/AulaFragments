package com.camargo.aulafrag.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.camargo.aulafrag.R
import com.camargo.aulafrag.adapters.BookAdapter
import com.camargo.aulafrag.adapters.BookListener
import com.camargo.aulafrag.model.Book
import kotlinx.android.synthetic.main.fragment_book.*
import kotlinx.android.synthetic.main.fragment_book.view.*

class BookFragment : Fragment(), BookListener {
    private lateinit var adapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book, container, false)
        // Inflate the layout for this fragment

        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        adapter = BookAdapter(this)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity)

    }

    override fun onItemClick(book: Book) {
        val bundle = Bundle()
        bundle.putInt("bookId", book.id!!)

        findNavController().navigate(R.id.navigateToInfoBooks, bundle)
    }
}
