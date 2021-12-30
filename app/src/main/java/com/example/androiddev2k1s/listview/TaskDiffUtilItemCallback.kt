package com.example.androiddev2k1s.listview

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_DATE
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_DESCRIPTION
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_TITLE
import com.example.androiddev2k1s.listview.ItemConst.getDateFormatted
import com.example.androiddev2k1s.models.Task

class TaskDiffUtilItemCallback : DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem

    override fun getChangePayload(oldItem: Task, newItem: Task): Any {
        val bundle = Bundle()

        if (oldItem.title != newItem.title)
            bundle.putString(EXTRA_TITLE, newItem.title)
        if (oldItem.description != newItem.description)
            bundle.putString(EXTRA_DESCRIPTION, newItem.description)
        if (oldItem.date != newItem.date)
            bundle.putString(EXTRA_DATE, getDateFormatted(newItem.date))

        return bundle
    }
}