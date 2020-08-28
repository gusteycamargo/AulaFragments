package com.camargo.aulafrag.api

import com.camargo.aulafrag.model.Book
import retrofit2.Call
import retrofit2.http.*

interface BookService {
    @GET("todos")
    fun getAll(): Call<List<Book>>

    @GET("todos/{id}")
    fun getAllByIds(@Path("id") ids: IntArray): Call<Book>

    @Headers("Content-Type: application/json")
    @POST("todos")
    fun insert(@Body todo: Book): Call<Book>

    @Headers("Content-Type: application/json")
    @PATCH("todos/{id}")
    fun update(@Path("id") id: Int, @Body todo: Book): Call<Book>

    @DELETE("todos/{id}")
    fun delete(@Path("id") id: Int): Call<Void>
}