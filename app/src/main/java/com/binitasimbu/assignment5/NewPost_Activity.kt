package com.binitasimbu.assignment5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.binitasimbu.assignment5.UserModel.AddPost

class NewPost_Activity : AppCompatActivity() {
    private lateinit var tvprofileimg: TextView;
    private lateinit var tvpostimg: TextView;
    private lateinit var post:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post_)
        tvprofileimg=findViewById(R.id.tvprofileimg)
        tvpostimg=findViewById(R.id.tvpostimg)
        post=findViewById(R.id.post)
        post.setOnClickListener{
            val UserPost=AddPost(tvprofileimg.text.toString(), tvpostimg.text.toString())
            val intent= Intent()
            intent.putExtra("UserPost", UserPost)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}