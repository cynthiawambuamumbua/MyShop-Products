package com.example.comments.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Comment.viewModel.CommentsViewModel
import com.example.products.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    val commentsViewModel: CommentsViewModel by viewModels()
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        commentsViewModel.fetchComments()
        commentsViewModel.commentsLiveData.observe(this, Observer {
                CommentsList ->
            Toast.makeText(baseContext, "fetched ${CommentsList?.size} comments", Toast.LENGTH_LONG)
                .show()
            binding.rvComments.layoutManager= LinearLayoutManager(this@MainActivity2)
            binding.rvComments.adapter= CommentsRvAdapter(CommentsList)

        })
        commentsViewModel.commentsLiveData.observe(this, Observer { commentsList ->
            Toast.makeText(baseContext, "fetched ${commentsList?.size} comments", Toast.LENGTH_LONG)
                .show()

        })
    }
}



