package com.camargo.aulafrag.adapters

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.camargo.aulafrag.R
import com.camargo.aulafrag.api.BookService
import com.camargo.aulafrag.model.Book
import kotlinx.android.synthetic.main.item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookAdapter(
    private val listener: BookListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.3.2:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(BookService::class.java)
    private var bookList: MutableList<Book> = mutableListOf()

    init {
        service.getAll().enqueue(object : Callback<List<Book>> {
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {}

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                bookList = response.body()!!.toMutableList()
                notifyDataSetChanged()
            }

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item,
            parent, false)
        return ViewHolder(v)

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).fillView(bookList[position])
    }
    override fun getItemCount() = bookList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(todo: Book) {
            itemView.textView1.text = Editable.Factory.getInstance().newEditable(todo.status + " " + todo.title)
            itemView.text_view_2.text = Editable.Factory.getInstance().newEditable(todo.description)

            itemView.setOnClickListener {
                listener.onItemClick(todo)
            }
        }
    }
}

