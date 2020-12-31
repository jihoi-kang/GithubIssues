package com.jay.issues.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.jay.issues.model.User

open class UserConverter {

    @TypeConverter
    fun fromString(value: String): User? {
        return Gson().fromJson(value, User::class.java)
    }

    @TypeConverter
    fun fromUser(user: User?): String {
        return Gson().toJson(user)
    }

}