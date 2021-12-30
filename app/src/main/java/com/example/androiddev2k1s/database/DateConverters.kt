package com.example.androiddev2k1s.database

import androidx.room.TypeConverter
import java.util.*

class DateConverters {
    @TypeConverter
    fun dateFromTimestamp(value: Long?): Date? {
        return value?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}