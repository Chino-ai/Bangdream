package com.example.animelover.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.animelover.core.domain.usecase.MemberItemUseCase

class MemberFavouriteViewModel(private val memberItemUseCase: MemberItemUseCase) : ViewModel() {


    val getFavourite = memberItemUseCase.getFavoriteMember().asLiveData()

}