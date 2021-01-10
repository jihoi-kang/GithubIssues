package com.jay.issues.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(primaryKeys = [("id")])
data class GithubIssue(
    val id: Int,
    val number: Int,
    val title: String,
    val body: String,
    val user: User,
    var repo: String,
    override var itemLayoutResId: Int
) : ItemViewType, Parcelable