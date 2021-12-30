package com.example.androiddev2k1s.listview

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.androiddev2k1s.models.Task

class TaskListAdapter (private val onItemChosenAction: (Int) -> Unit,
                       private val onItemDeleteAction: (Int) -> Unit
) : ListAdapter<Task, TaskHolder>(TaskDiffUtilItemCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder =
        TaskHolder.create(parent, onItemChosenAction, onItemDeleteAction)

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun onBindViewHolder(holder: TaskHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            payloads.last().takeIf {
                it is Bundle
            }?.let {
                holder.updateFields(it as Bundle)
            }?: run {
                super.onBindViewHolder(holder, position, payloads)
            }
        }
    }
    override fun submitList(list: MutableList<Task>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}