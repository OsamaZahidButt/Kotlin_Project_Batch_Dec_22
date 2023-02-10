package com.thetapractice.kotlinprojectbatchdec22.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var Id: Int,
    @ColumnInfo(name = "Username")
    var Username: String,
    @ColumnInfo(name = "Email")
    var Email: String,
    @ColumnInfo(name = "Phone")
    var Phone: String
)