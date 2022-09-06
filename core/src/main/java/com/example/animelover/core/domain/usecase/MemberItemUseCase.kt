package com.dicoding.tourismapp.core.domain.usecase

import com.dicoding.tourismapp.core.data.Resource
import com.example.animelover.core.data.source.remote.response.MemberItem
import com.example.animelover.core.domain.model.Member
import kotlinx.coroutines.flow.Flow

interface MemberItemUseCase {
    fun getAllMember(): Flow<Resource<List<Member>>>
    fun getFavoriteMember(): Flow<List<Member>>
    fun setFavoriteMember(member: Member, state: Boolean)
}