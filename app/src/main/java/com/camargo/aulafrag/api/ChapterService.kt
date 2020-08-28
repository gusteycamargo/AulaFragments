package com.camargo.aulafrag.api

import com.camargo.aulafrag.model.Chapter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChapterService {

    @GET("chapters/{id}")
    fun getById(@Path("id") ids: Int): Call<Chapter>
}