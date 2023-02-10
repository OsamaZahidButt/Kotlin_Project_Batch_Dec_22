package com.thetapractice.kotlinprojectbatchdec22.Dao

import androidx.room.*
import com.thetapractice.kotlinprojectbatchdec22.Entity.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: UserEntity)
    @Update
    fun updateUser(user: UserEntity)
    @Delete
    fun deleteUser(user: UserEntity)
    @Query("Select * from UserEntity")
    fun selectUser(): List<UserEntity>
}