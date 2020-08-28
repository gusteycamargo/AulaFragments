package com.camargo.aulafrag.api

import com.camargo.aulafrag.model.Book
import retrofit2.Call
import retrofit2.http.*

interface BookService {
    @GET("books")
    fun getAll(): Call<List<Book>>

    @GET("books/{id}")
    fun getAllByIds(@Path("id") ids: Int): Call<Book>

    @Headers("Content-Type: application/json")
    @POST("books")
    fun insert(@Body todo: Book): Call<Book>

    @Headers("Content-Type: application/json")
    @PATCH("books/{id}")
    fun update(@Path("id") id: Int, @Body todo: Book): Call<Book>

    @DELETE("books/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}