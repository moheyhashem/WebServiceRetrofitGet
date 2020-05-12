package com.example.webserviceretrofitget

import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    internal lateinit var contentTV: TextView
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contentTV = findViewById(R.id.contentTV)
    }

    // public interface GithubService {
    // @GET("/users")
    //Call<ResponseBody> getUsers();
    // }
    interface JSONPlaceHolderService {
        @get:GET("Posts")
        val posts: Call<Void>

    }

    fun LoadData(view: View) {
        val Link = "https://jsonplaceholder.typicode.com/posts"
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").build()
        val jsonPlaceHolderService = retrofit.create(JSONPlaceHolderService::class.java)
        jsonPlaceHolderService.posts.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                contentTV.text = response.body()!!.toString()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {

            }
        })


    }

}

