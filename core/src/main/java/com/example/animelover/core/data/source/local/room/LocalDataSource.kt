package com.example.animelover.core.data.source.local.room

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val bangdreamDao: BangdreamDao) {


    fun getAllMember(): Flow<List<com.example.animelover.core.data.source.local.entity.MemberEntity>> = bangdreamDao.getAllMember()

    fun getFavoriteMember():Flow<List<com.example.animelover.core.data.source.local.entity.MemberEntity>> = bangdreamDao.getFavoriteMember()
    suspend fun insertMember(memberList: List<com.example.animelover.core.data.source.local.entity.MemberEntity>)= bangdreamDao.insertMember(memberList)

    fun setFavoriteTourism(bangdream : com.example.animelover.core.data.source.local.entity.MemberEntity, newState: Boolean) {
        bangdream.isFavourite = newState
        bangdreamDao.updateFavoriteMember(bangdream)
    }
}