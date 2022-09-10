package com.example.animelover.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.di.viewModelModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemberFavouriteViewModel(private val memberItemUseCase: MemberItemUseCase): ViewModel(){

    /*fun getFavourite() = viewModelScope.launch(Dispatchers.IO) {
        memberItemUseCase.getFavoriteMember().asLiveData()
    }*/

    val getFavourite = memberItemUseCase.getFavoriteMember().asLiveData()

}