package com.example.animelover.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.core.domain.model.Member
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemberViewModel(private val memberItemUseCase: MemberItemUseCase): ViewModel() {

   /* fun getAllMember() = viewModelScope.launch(Dispatchers.IO) {
        memberItemUseCase.getAllMember().asLiveData()
    }*/
    val member = memberItemUseCase.getAllMember().asLiveData()
}