package com.thetapractice.kotlinprojectbatchdec22.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thetapractice.kotlinprojectbatchdec22.Dao.UserDao
import com.thetapractice.kotlinprojectbatchdec22.Entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        fun getDatabase(context: Context): UserDatabase {
            var database: UserDatabase? = null
            if (database != null) {
                return database
            }
            database = Room.databaseBuilder(context, UserDatabase::class.java, "Database").allowMainThreadQueries().build()
            return database
        }
    }
}