package com.example.webserviceretrofitget

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("posts/1")
    fun getPost(): Call<GetPostResponse>
}