package com.example.animelover.core.domain.repository

import com.example.animelover.core.data.Resource
import com.example.animelover.core.domain.model.Member
import kotlinx.coroutines.flow.Flow

interface IMemberItemRepository {
    fun getAllTourism(): Flow<Resource<List<Member>>>

    fun getFavoriteTourism(): Flow<List<Member>>

    fun setFavoriteTourism(member: Member, state: Boolean)
}