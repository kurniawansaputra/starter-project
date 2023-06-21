package com.example.starterproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.starterproject.data.source.response.DataItem
import com.example.starterproject.databinding.ItemRowUserBinding

class UserAdapter(private val userList: List<DataItem>, private val context: Context): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(userList[position]) {
                val urlAvatar = avatar
                val name = "$firstName $lastName"
                val email = email

                binding.apply {
                    textName.text = name
                    textEmail.text = email

                    Glide.with(context)
                        .load(urlAvatar)
                        .centerCrop()
                        .into(ivAvatar)
                }
            }
        }
    }

    override fun getItemCount(): Int = userList.size
}