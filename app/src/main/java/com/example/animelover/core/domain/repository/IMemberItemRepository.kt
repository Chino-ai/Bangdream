package com.example.animelover.core.domain.repository

import com.dicoding.tourismapp.core.data.Resource
import com.example.animelover.core.data.source.remote.response.MemberItem
import com.example.animelover.core.domain.model.Member
import kotlinx.coroutines.flow.Flow

interface IMemberItemRepository {
    fun getAllTourism(): Flow<Resource<List<Member>>>

    fun getFavoriteTourism(): Flow<List<Member>>

    fun setFavoriteTourism(member: Member, state: Boolean)
}