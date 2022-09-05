package com.example.animelover.core.di

import com.dicoding.tourismapp.core.domain.usecase.MemberItemInteractor
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.core.ui.detail.MemberDetailViewModel
import com.example.animelover.core.ui.favourite.MemberFavouriteViewModel
import com.example.animelover.core.ui.home.MemberViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MemberItemUseCase> { MemberItemInteractor(get()) }

}

val viewModelModule = module {
    viewModel { MemberViewModel(get()) }
    viewModel { MemberFavouriteViewModel(get()) }
    viewModel {MemberDetailViewModel(get()) }
}
