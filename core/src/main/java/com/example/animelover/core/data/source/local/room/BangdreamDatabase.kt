package com.example.animelover.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.example.animelover.core.data.source.local.entity.MemberEntity::class], version = 4, exportSchema = false)
abstract class BangdreamDatabase : RoomDatabase() {

    abstract fun bangdreamDao(): BangdreamDao

}