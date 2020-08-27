package com.camargo.aulafrag.model

data class ToDo(
    var status: String,
    var title: String,
    var description: String) {

    var id: Int? = null
}