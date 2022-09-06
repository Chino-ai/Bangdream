package com.example.animelover.di

import com.dicoding.tourismapp.core.domain.usecase.MemberItemInteractor
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.ui.detail.MemberDetailViewModel
import com.example.animelover.ui.favourite.MemberFavouriteViewModel
import com.example.animelover.ui.home.MemberViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MemberItemUseCase> { MemberItemInteractor(get()) }

}

val viewModelModule = module {
    viewModel { MemberViewModel(get()) }
    viewModel { MemberFavouriteViewModel(get()) }
    viewModel { MemberDetailViewModel(get()) }
}
