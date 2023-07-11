package com.example.products.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comments.repository.commentsRepository
import kotlinx.coroutines.launch
import org.w3c.dom.Comment

private val Any.comments: List<Comment>?
    get() {
        TODO("Not yet implemented")
    }
private val Unit.isSuccessful: Boolean
    get() {
        TODO("Not yet implemented")
    }

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
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }

    }
}

private fun Any.string(): String? {
    TODO("Not yet implemented")
}

private fun Unit.errorBody(): Any {
    TODO("Not yet implemented")
}

private fun Unit.body(): Any {
    TODO("Not yet implemented")
}
