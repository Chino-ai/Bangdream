package com.dicoding.tourismapp.core.domain.usecase


import com.example.animelover.core.data.source.remote.response.MemberItem
import com.example.animelover.core.domain.model.Member
import com.example.animelover.core.domain.repository.IMemberItemRepository


class MemberItemInteractor(private val resultItemRepository: IMemberItemRepository): MemberItemUseCase {

    override fun getAllMember() = resultItemRepository.getAllTourism()

    override fun getFavoriteMember() = resultItemRepository.getFavoriteTourism()

    override fun setFavoriteMember(resultsItem: Member, state: Boolean) = resultItemRepository.setFavoriteTourism(resultsItem,state)
}