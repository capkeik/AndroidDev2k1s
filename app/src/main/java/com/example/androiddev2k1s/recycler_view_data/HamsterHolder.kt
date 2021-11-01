package com.example.androiddev2k1s.recycler_view_data

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev2k1s.activities.ProfileActivity
import com.example.androiddev2k1s.databinding.ItemHamsterBinding

class HamsterHolder(
    private val binding: ItemHamsterBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Hamster) {
        with(binding) {
            tvName.text = item.name
            tvBreed.text = item.breed
            ivImage.setImageResource(item.photo)
        }
        itemView.setOnClickListener {
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, ProfileActivity::class.java)
                intent.putExtra("id", item.id)
                print(item.id)
                context.startActivity(intent)
            }
        }
    }

    companion object {

        fun create(parent: ViewGroup) = HamsterHolder(
            ItemHamsterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}