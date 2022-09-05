package com.dicoding.tourismapp.core.data.source.local

import com.dicoding.tourismapp.core.data.source.local.room.BangdreamDao
import com.example.animelover.core.data.source.local.entity.MemberEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val bangdreamDao: BangdreamDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: BangdreamDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    fun getAllMember(): Flow<List<MemberEntity>> = bangdreamDao.getAllMember()

    fun getFavoriteMember():Flow<List<MemberEntity>> = bangdreamDao.getFavoriteMember()
    suspend fun insertMember(memberList: List<MemberEntity>)= bangdreamDao.insertMember(memberList)

    fun setFavoriteTourism(bangdream : MemberEntity, newState: Boolean) {
        bangdream.isFavourite = newState
        bangdreamDao.updateFavoriteMember(bangdream)
    }
}