package com.dicoding.tourismapp.core.data.source.local.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animelover.core.data.source.local.entity.MemberEntity

@Database(entities = [MemberEntity::class], version = 4, exportSchema = false)
abstract class BangdreamDatabase : RoomDatabase() {

    abstract fun bangdreamDao(): BangdreamDao

    companion object {
        @Volatile
        private var INSTANCE: BangdreamDatabase? = null

        fun getInstance(context: Context): BangdreamDatabase =
            INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                BangdreamDatabase::class.java,
                "Bangdream.db"
            )
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            instance
        }
    }
}