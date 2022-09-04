package com.example.animelover.core.di

import android.content.Context

import com.dicoding.tourismapp.core.data.source.local.LocalDataSource

import com.dicoding.tourismapp.core.data.source.local.room.BangdreamDatabase
import com.dicoding.tourismapp.core.data.source.remote.network.ApiConfig
import com.dicoding.tourismapp.core.domain.usecase.MemberItemInteractor
import com.dicoding.tourismapp.core.domain.usecase.MemberItemUseCase
import com.example.animelover.core.data.MemberRepository
import com.example.animelover.core.data.source.remote.RemoteDataSource
import com.example.animelover.core.domain.repository.IMemberItemRepository
import com.example.animelover.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): IMemberItemRepository {
        val database = BangdreamDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.bangdreamDao())
        val appExecutors = AppExecutors()

        return MemberRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
    fun provideTourismUseCase(context: Context): MemberItemUseCase {
        val repository = provideRepository(context)
        return MemberItemInteractor(repository)
    }

}
