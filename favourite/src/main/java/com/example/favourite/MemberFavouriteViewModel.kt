package com.example.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase

class MemberFavouriteViewModel(memberItemUseCase: MemberItemUseCase): ViewModel(){
    val getFavourite = memberItemUseCase.getFavoriteMember().asLiveData()
}