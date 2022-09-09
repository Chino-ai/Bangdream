package com.example.animelover.ui.detail

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.core.domain.model.Member
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemberDetailViewModel(private val memberItemUseCase: MemberItemUseCase) : ViewModel() {
   /* fun setFavouriteMember(member: Member, newStatus: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        memberItemUseCase.setFavoriteMember(member,newStatus)
    }*/

    fun setFavouriteMember(member: Member, newStatus: Boolean) = memberItemUseCase.setFavoriteMember(member,newStatus)


}