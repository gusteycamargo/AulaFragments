package com.camargo.aulafrag.adapters

import com.camargo.aulafrag.model.Book

interface BookListener {
    fun onItemClick(todo: Book)
}