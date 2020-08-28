package com.camargo.aulafrag.model

data class Book(
    var status: String,
    var title: String,
    var description: String) {

    var id: Int? = null
}