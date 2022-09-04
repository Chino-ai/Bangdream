package com.example.animelover.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.core.di.Injection
import com.example.animelover.core.ui.detail.MemberDetailViewModel
import com.example.animelover.core.ui.favourite.MemberFavouriteViewModel
import com.example.animelover.core.ui.home.MemberViewModel

class ViewModelFactory private constructor(private val memberItemUseCase: MemberItemUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                instance
                    ?: ViewModelFactory(
                        Injection.provideTourismUseCase(
                            context
                        )
                    )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MemberViewModel::class.java) -> {
                MemberViewModel(memberItemUseCase) as T
            }
            modelClass.isAssignableFrom(MemberDetailViewModel::class.java) -> {
                MemberDetailViewModel(memberItemUseCase) as T
            }
            modelClass.isAssignableFrom(MemberFavouriteViewModel::class.java) -> {
                MemberFavouriteViewModel(memberItemUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}