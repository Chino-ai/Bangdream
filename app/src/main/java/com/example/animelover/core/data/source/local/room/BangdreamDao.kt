package com.dicoding.tourismapp.core.data.source.local.room

import androidx.room.*
import com.example.animelover.core.data.source.local.entity.MemberEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface BangdreamDao {

    @Query("SELECT * FROM member")
    fun getAllMember(): Flow<List<MemberEntity>>

    @Query("SELECT * FROM member where isFavourite = 1")
    fun getFavoriteMember(): Flow<List<MemberEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(tourism: List<MemberEntity>)

    @Update
     fun updateFavoriteMember(member: MemberEntity)
}
