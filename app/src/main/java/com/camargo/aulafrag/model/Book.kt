package com.camargo.aulafrag.model

import java.io.Serializable

data class Book(
    var title: String,
    var author: String,
    var publishingCompany: String,
    var chapters: List<String>,
    var year: Int,
    var edition: Int) : Serializable {

    var id: Int? = null
}