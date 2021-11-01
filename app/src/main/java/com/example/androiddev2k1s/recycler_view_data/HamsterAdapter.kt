package com.example.androiddev2k1s.recycler_view_data

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HamsterAdapter (
    private val list: List<Hamster>
) :RecyclerView.Adapter<HamsterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int
    ) : HamsterHolder = HamsterHolder.create(parent)

    override fun onBindViewHolder(holder: HamsterHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}