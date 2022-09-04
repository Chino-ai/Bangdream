package com.dicoding.tourismapp.core.data.source.remote.network



import com.example.animelover.core.data.source.remote.response.MemberResponse
import retrofit2.http.GET

interface ApiService {
    @GET("members/")
    suspend fun getListMember(): MemberResponse
}