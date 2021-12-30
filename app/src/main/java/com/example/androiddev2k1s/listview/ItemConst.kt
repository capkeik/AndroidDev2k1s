package com.example.androiddev2k1s.listview

import java.text.SimpleDateFormat
import java.util.*

object ItemConst {

    const val EXTRA_TITLE = "TITLE"
    const val EXTRA_DESCRIPTION = "DESCRIPTION"
    const val EXTRA_DATE = "DATE"
    const val EXTRA_TASK_ID = "TASK_ID"

    fun getDateFormatted(date: Date?): String {
        return if (date != null) {
            val dateFormat = SimpleDateFormat("EEE, MMM dd, ''yy", Locale.getDefault())
            dateFormat.format(date)
        } else {
            "Infinity"
        }
    }
}