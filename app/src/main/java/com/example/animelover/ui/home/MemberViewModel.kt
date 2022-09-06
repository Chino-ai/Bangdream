package com.example.animelover.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase

class MemberViewModel(memberItemUseCase: MemberItemUseCase): ViewModel() {

    val member = memberItemUseCase.getAllMember().asLiveData()
}