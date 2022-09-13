package com.example.animelover.ui.detail

import androidx.lifecycle.ViewModel
import com.example.animelover.core.domain.usecase.MemberItemUseCase
import com.example.animelover.core.domain.model.Member

class MemberDetailViewModel(private val memberItemUseCase: MemberItemUseCase) : ViewModel() {

    fun setFavouriteMember(member: Member, newStatus: Boolean) =
        memberItemUseCase.setFavoriteMember(member, newStatus)


}