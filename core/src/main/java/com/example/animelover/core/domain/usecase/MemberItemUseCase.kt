package com.example.animelover.core.domain.usecase

import com.example.animelover.core.data.Resource
import com.example.animelover.core.domain.model.Member
import kotlinx.coroutines.flow.Flow

interface MemberItemUseCase {
    fun getAllMember(): Flow<Resource<List<Member>>>
    fun getFavoriteMember(): Flow<List<Member>>
    fun setFavoriteMember(member: Member, state: Boolean)
}