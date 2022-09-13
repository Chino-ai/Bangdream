package com.example.animelover.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.animelover.core.domain.usecase.MemberItemUseCase

class MemberViewModel(private val memberItemUseCase: MemberItemUseCase) : ViewModel() {


    val member = memberItemUseCase.getAllMember().asLiveData()
}