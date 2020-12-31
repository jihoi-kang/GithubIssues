package com.jay.issues.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(primaryKeys = [("id")])
data class User(
    val id: Int,
    val avatar_url: String,
    val login: String,
) : Parcelable