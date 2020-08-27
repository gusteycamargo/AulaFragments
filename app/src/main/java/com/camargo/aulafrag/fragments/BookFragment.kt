package com.camargo.aulafrag.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.camargo.aulafrag.R
import com.camargo.aulafrag.adapters.ToDoAdapter
import com.camargo.aulafrag.adapters.ToDoListener
import com.camargo.aulafrag.model.ToDo
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment : Fragment(), ToDoListener {
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        adapter = ToDoAdapter(this)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity)
    }

    override fun onBtSaveClick() {

    }

    override fun onBtShareClick(todo: ToDo) {

    }


    override fun onBtDeleteClick(todo: ToDo) {

    }

    override fun onItemEditClick(todo: ToDo) {

    }

    override fun onItemClick(todo: ToDo) {

    }

    override fun onLongClick(todo: ToDo) {

    }
}
