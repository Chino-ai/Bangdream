package com.example.animelover.core.di

import androidx.room.Room
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.room.BangdreamDatabase
import com.dicoding.tourismapp.core.data.source.remote.network.ApiService
import com.example.animelover.core.data.MemberRepository
import com.example.animelover.core.data.source.remote.RemoteDataSource
import com.example.animelover.core.domain.repository.IMemberItemRepository
import com.example.animelover.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform.Companion.get
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory {
        get<BangdreamDatabase>().bangdreamDao()
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            BangdreamDatabase::class.java,
            "Bangdream.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://bandori.party/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }





}

val repositoryModule = module{
    single {
        LocalDataSource(get())
    }
    single{
        com.example.animelover.core.data.source.remote.RemoteDataSource(get())
    }

    factory {
        AppExecutors()
    }
    single<IMemberItemRepository>{
        com.example.animelover.core.data.MemberRepository(get(), get(), get())
    }
}