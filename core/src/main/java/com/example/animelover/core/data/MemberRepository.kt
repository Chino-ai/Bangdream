package com.example.animelover.core.data

import com.example.animelover.core.data.source.local.room.LocalDataSource
import com.example.animelover.core.data.source.remote.network.ApiResponse
import com.example.animelover.core.data.source.remote.response.MemberItem
import com.example.animelover.core.domain.model.Member
import com.example.animelover.core.domain.repository.IMemberItemRepository
import com.example.animelover.core.utils.AppExecutors
import com.example.animelover.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MemberRepository(
    private val remoteDataSource: com.example.animelover.core.data.source.remote.RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMemberItemRepository {

    override fun getAllTourism(): Flow<Resource<List<Member>>> =
        object : NetworkBoundResource<List<Member>, List<MemberItem>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Member>> {
                return localDataSource.getAllMember().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Member>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MemberItem>>> =
                remoteDataSource.getListMember()

            override suspend fun saveCallResult(data: List<MemberItem>) {
                val memberList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMember(memberList)

            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Member>> {
        return localDataSource.getFavoriteMember().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(member: Member, state: Boolean) {
        val memberEntity = DataMapper.mapDomainToEntity(member)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(memberEntity, state) }
    }
}

