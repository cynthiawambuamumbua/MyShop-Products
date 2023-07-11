package com.example.products.model

data class Comments (
    val id:Int,
    val postId:Int,
    val userName:String,
    val body:String,
    val userId:Int,

    )