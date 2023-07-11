package com.example.products.model

data class CommentsResponse(
    val total:Int,
    val skip:Int,
    val limit:Int,
    val comments: List<Comments>
)
