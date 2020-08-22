package com.sunhawk.myapplication.api

import com.sunhawk.myapplication.model.UserProfile

object ApiTransformer {

    suspend fun getUserProfile(user: String): UserProfile {
        val retrofit = RetrofitFactory.retrofit
        val apiService = retrofit.create(ApiService::class.java)
        return apiService.getProfile(user);
    }

}