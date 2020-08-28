package com.camargo.aulafrag.adapters

import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.camargo.aulafrag.R
import com.camargo.aulafrag.api.ChapterService
import com.camargo.aulafrag.model.Chapter
import kotlinx.android.synthetic.main.item_chapters.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChapterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var chapterList: MutableList<String> = mutableListOf()

    fun updateList(chapters: MutableList<String>) {
        chapterList = chapters

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_chapters,
            parent, false)
        return ViewHolder(v)

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).fillView(chapterList[position])
    }
    override fun getItemCount() = chapterList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(title: String) {
            itemView.title.text = Editable.Factory.getInstance().newEditable(title)
        }
    }
}