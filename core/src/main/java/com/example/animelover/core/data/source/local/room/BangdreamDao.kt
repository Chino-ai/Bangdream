package com.dicoding.tourismapp.core.data.source.local.room

import androidx.room.*
import com.example.animelover.core.data.source.local.entity.MemberEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface BangdreamDao {

    @Query("SELECT * FROM member")
    fun getAllMember(): Flow<List<com.example.animelover.core.data.source.local.entity.MemberEntity>>

    @Query("SELECT * FROM member where isFavourite = 1")
    fun getFavoriteMember(): Flow<List<com.example.animelover.core.data.source.local.entity.MemberEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(tourism: List<com.example.animelover.core.data.source.local.entity.MemberEntity>)

    @Update
     fun updateFavoriteMember(member: com.example.animelover.core.data.source.local.entity.MemberEntity)
}
