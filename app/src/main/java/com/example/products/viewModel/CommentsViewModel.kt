package com.example.comments.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comments.repository.commentsRepository
import kotlinx.coroutines.launch
import org.w3c.dom.Comment

class CommentsViewModel:ViewModel(){
    val commentsRepo= commentsRepository()
    val commentsLiveData=MutableLiveData<List<Comment>>()
    val errorLiveData=MutableLiveData<String>()

    fun fetchComments(){
        viewModelScope.launch {
            val response=commentsRepo.getComments()
            if (response.isSuccessful){
                commentsLiveData.postValue(response.body()?.comments)
            }
            else errorLiveData.postValue(response.errorBody()?.string())
        }

    }
}
