package com.example.animelover.core.data.source.remote

import android.util.Log
import com.example.animelover.core.data.source.remote.network.ApiResponse
import com.example.animelover.core.data.source.remote.network.ApiService
import com.example.animelover.core.data.source.remote.response.MemberItem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getListMember(): Flow<ApiResponse<List<MemberItem>>> {
       return flow{
           try{
               val response  =apiService.getListMember()
               val dataArray = response.results
               if (dataArray.isNotEmpty()){
                   emit(ApiResponse.Success(response.results))
               }else{
                   emit(ApiResponse.Empty)
               }
           }catch (e: Exception){
               emit(ApiResponse.Error(e.toString()))
               Log.e("RemoteDataSource",e.toString())
           }
       }.flowOn(Dispatchers.IO)

    }
}

