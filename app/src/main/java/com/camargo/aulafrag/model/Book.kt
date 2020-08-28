package com.camargo.aulafrag.model

data class Book(
    var title: String,
    var author: String,
    var publishingCompany: String,
    var year: Int,
    var edition: Int) {

    var id: Int? = null
}