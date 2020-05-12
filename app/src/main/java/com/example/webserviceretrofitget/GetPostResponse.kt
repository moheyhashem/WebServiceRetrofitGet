package com.example.webserviceretrofitget


import com.google.gson.annotations.SerializedName

data class GetPostResponse(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)