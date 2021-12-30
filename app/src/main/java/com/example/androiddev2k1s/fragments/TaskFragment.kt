package com.example.androiddev2k1s.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androiddev2k1s.MainActivity
import com.example.androiddev2k1s.R
import com.example.androiddev2k1s.database.TaskDatabase
import com.example.androiddev2k1s.databinding.FragmentTaskBinding
import com.example.androiddev2k1s.models.Task
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class TaskFragment : Fragment(R.layout.fragment_task) {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var taskDB: TaskDatabase
    private var calendar: Calendar? = null
    private var currentTaskId: Int? = null
    private var longitude: Double? = 49.1221400
    private var latitude: Double? = 55.7887400



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTaskBinding.bind(view)
        taskDB = (requireActivity() as MainActivity).taskDB

        binding.apply {
            toolbar.apply {
                setNavigationIcon(R.drawable.ic_arrow_back)
                setNavigationOnClickListener {
                    (activity as? MainActivity)?.onBackPressed()
                }
                setOnMenuItemClickListener { onOptionsItemSelected(it) }
            }
            btnSetDate.setOnClickListener {
                showDatePicker()
            }
            btnSubmit.setOnClickListener{
                saveTask()
            }
            btnSetLocation.setOnClickListener{
//                setLocation()
            }
        }
        isTaskExists()
    }


    private fun addTask() {
        binding.apply {
            val newTask = Task(
                0,
                etTitle.text.toString(),
                etDescription.text.toString(),
                calendar?.time,
                longitude,
                latitude
            )
            taskDB.taskDao().add(newTask)
        }
    }

    private fun saveTask() {
        currentTaskId?.let {
            updateTask(it)
        }
        if (currentTaskId == null && isDataCorrect()) {
            addTask()
            showMessage("Task successfully added")
            returnToTasksFragment()
        }
    }

    private fun updateTask(id: Int) {
        if (isDataCorrect()) {
            updateData(id)
            showMessage("Task successfully updated.")
            returnToTasksFragment()
        }
    }

    private fun isTaskExists() {
        arguments?.getInt("TASK_ID")?.let {
            currentTaskId = it
            setTask(it)
        }
    }

    private fun setTask(id: Int) {
        val task = taskDB.taskDao().getTaskById(id)
        binding.apply {
            etTitle.setText(task?.title)
            etDescription.setText(task?.description)
            task?.date?.let {
                calendar = Calendar.getInstance()
                calendar?.time = it
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun updateData(id: Int) {
        val task = taskDB.taskDao().getTaskById(id)
        binding.apply {
            task?.let {
                it.title = etTitle.text.toString()
                it.description = etDescription.text.toString()
                calendar?.apply {
                    it.date = time
                }
                taskDB.taskDao().updateTasks(task)
            }
        }
    }

    private fun isDataCorrect(): Boolean {
        binding.apply {
            if (etTitle.text.toString().isEmpty()) {
                showMessage("Add title")
                return false
            }
            if (etDescription.text.toString().isEmpty()) {
                showMessage("Add description")
                return false
            }
        }
        return true
    }

    private fun showDatePicker() {
        calendar = Calendar.getInstance()
        val datePickerFragment = DatePickerFragment()
        val supportFragmentManager = requireActivity().supportFragmentManager

        supportFragmentManager.setFragmentResultListener(
            "REQUEST_KEY",
            viewLifecycleOwner
        ) { resultKey, bundle ->
            if (resultKey == "REQUEST_KEY") {
                calendar?.timeInMillis = bundle.getLong("DATE")
            }
        }
        datePickerFragment.show(supportFragmentManager, "DatePickerDialog")
    }

    private fun returnToTasksFragment() {
        (activity as? MainActivity)?.onBackPressed()
    }
}
