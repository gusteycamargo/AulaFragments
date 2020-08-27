package com.camargo.aulafrag.adapters

import com.camargo.aulafrag.model.ToDo

interface ToDoListener {
    fun onItemClick(todo: ToDo)

    fun onLongClick(todo: ToDo)

    fun onItemEditClick(todo: ToDo)

    fun onBtSaveClick()

    fun onBtDeleteClick(todo: ToDo)

    fun onBtShareClick(todo: ToDo)

}