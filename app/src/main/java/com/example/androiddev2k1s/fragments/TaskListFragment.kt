package com.example.androiddev2k1s.fragments

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androiddev2k1s.R
import com.example.androiddev2k1s.database.TaskDatabase
import com.example.androiddev2k1s.databinding.FragmentTaskListBinding
import com.example.androiddev2k1s.listview.ItemConst.EXTRA_TASK_ID
import com.example.androiddev2k1s.listview.TaskListAdapter
import com.example.androiddev2k1s.models.Task

class TaskListFragment : Fragment(R.layout.fragment_task_list) {

    private lateinit var binding: FragmentTaskListBinding
    private var taskListAdapter: TaskListAdapter? = null
    private lateinit var taskDB: TaskDatabase
    private lateinit var tasks: List<Task>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTaskListBinding.bind(view)

        taskDB = TaskDatabase.getInstance(this.requireContext())

        taskListAdapter = TaskListAdapter({showTaskFragment(it)}, {deleteItemById(it)})

        binding.apply {
            toolbar.setOnMenuItemClickListener {
                onOptionsItemSelected(it)
            }

            fabAdd.setOnClickListener {
                showTaskFragment(null)
            }

            rvTasks.run {
                adapter = taskListAdapter
            }
        }

        val list = taskDB.taskDao().getAllTasks()


        if (list.isEmpty()) {
            binding.tvStart.visibility = View.VISIBLE
            binding.rvTasks.visibility = View.GONE
        } else {
            updateTaskList(list)
        }
    }

    private fun showTaskFragment(id: Int?) {
        var bundle: Bundle? = null
        id?.let {
            bundle = Bundle().apply {
                putInt(EXTRA_TASK_ID, id)
            }
        }
        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .build()

        findNavController().navigate(
            R.id.action_taskListFragment_to_taskFragment,
            bundle,
            options
        )
    }

    private fun updateTaskList(list: List<Task>) {
        binding.apply {
            if (list.isEmpty()) {
                tvStart.visibility = View.VISIBLE
                rvTasks.visibility = View.GONE
            } else {
                tvStart.visibility = View.GONE
                rvTasks.visibility = View.VISIBLE
            }
        }
        taskListAdapter?.submitList(ArrayList(tasks))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_delete -> {
                if(taskDB.taskDao().getAllTasks().isEmpty()) {
                    showMessage("No tasks yet")
                } else {
                deleteAll()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteAll() {
        taskDB.taskDao().deleteAll()
        showMessage("All tasks are deleted")
    }

    private fun deleteItemById(id: Int) {
        taskDB.taskDao().deleteTaskById(id)
        updateTaskList(taskDB.taskDao().getAllTasks())
        showMessage("Element #$id was deleted")
    }


    private fun showMessage(message: String) {
        Toast.makeText(
        context,
        message,
        Toast.LENGTH_SHORT
        ).show()
    }
}