package com.example.webserviceretrofitget

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // public interface GithubService {
    // @GET("/users")
    //Call<ResponseBody> getUsers();
    // }
//    interface JSONPlaceHolderService {
//        @get:GET("Posts")
//        val posts: Call<Void>
//
//    }

    fun loadData(view: View) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //Creating an object of our api interface
        val api = retrofit.create(ApiService::class.java)

        //Defining the method
        val post: Call<GetPostResponse> = api.getPost()

        post.enqueue(object : Callback<GetPostResponse>{
            override fun onFailure(call: Call<GetPostResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<GetPostResponse>,
                response: Response<GetPostResponse>
            ) {
                post_title.text = response.body()?.title
                post_body.text = response.body()?.body
            }

        })

//        val Link = "https://jsonplaceholder.typicode.com/posts"
//        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").build()
//        val jsonPlaceHolderService = retrofit.create(JSONPlaceHolderService::class.java)
//        jsonPlaceHolderService.posts.enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                contentTV.text = response.body()!!.toString()
//            }
//
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//
//            }
//        })


    }

}

