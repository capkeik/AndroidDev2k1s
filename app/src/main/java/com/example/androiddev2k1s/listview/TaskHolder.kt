package com.example.androiddev2k1s.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev2k1s.databinding.ItemTaskBinding
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_DATE
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_DESCRIPTION
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_TITLE
import com.example.androiddev2k1s.listview.ItemConst.getDateFormatted
import com.example.androiddev2k1s.models.Task

class TaskHolder (
    private val binding: ItemTaskBinding,
    private val onItemChosenAction: (Int) -> Unit,
    private val onItemDeleteAction: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var taskToDisplay: Task? = null

    init {
        itemView.setOnClickListener {
            taskToDisplay?.run {
                onItemChosenAction(this.id)
            }
        }
    }

    fun bind(task: Task): Unit {
        this.taskToDisplay = task
        with(binding) {
            tvTitle.text = task.title
            tvDescription.text = task.description
            tvDueDate.text = getDateFormatted(task.date)

            ibDelete.setOnClickListener {
                taskToDisplay?.run {
                    onItemDeleteAction(this.id)
                }
            }
        }
    }

    fun updateFields(bundle: Bundle?) {
        with(binding) {
            if (bundle?.containsKey(EXTRA_TITLE) == true) {
                bundle.getString(EXTRA_TITLE).also {
                    tvTitle.text = it
                }
            }

            if (bundle?.containsKey(EXTRA_DESCRIPTION) == true) {
                bundle.getString(EXTRA_DESCRIPTION).also {
                    tvDescription.text = it
                }
            }

            if (bundle?.containsKey(EXTRA_DATE) == true) {
                bundle.getString(EXTRA_DATE).also {
                    tvDueDate.text = it
                }
            }
        }
    }
    companion object {
        fun create(parent: ViewGroup, onItemChosenAction: (Int) -> Unit, onItemDeleteAction: (Int) -> Unit) =
            TaskHolder (ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                onItemChosenAction, onItemDeleteAction)
    }
}
