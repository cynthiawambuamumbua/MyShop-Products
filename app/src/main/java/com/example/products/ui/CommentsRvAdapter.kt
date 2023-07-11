package com.example.comments.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.products.databinding.CommentsListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import org.w3c.dom.Comment

class CommentsRvAdapter(var comments: List<Comment>):RecyclerView.Adapter<CommentsRvAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):CommentsViewHolder {
        val binding=CommentsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder:CommentsViewHolder, position: Int) {
        val currentComments = comments.get(position)
        val binding = holder.binding
        binding.tvid.text=currentComments.id.toString()
        binding.tvimage.tag=currentComments
        binding.tvUsername.text=currentComments.userName
        binding.tvbody.text=currentComments.body
        binding.tvpostId.text=currentComments.postId.toString()
        binding.tvuserId.text=currentComments.userId.toString()


        Picasso
            .get().load(currentComments.toString())
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.tvimage)

    }


    override fun getItemCount(): Int {
      return comments.size
    }

    class CommentsViewHolder(var binding: CommentsListBinding): RecyclerView.ViewHolder(binding.root)
}
