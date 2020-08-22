package com.sunhawk.groundstation.api

import com.sunhawk.groundstation.model.UserProfile

object ApiTransformer {

    suspend fun getUserProfile(user: String): UserProfile {
        val retrofit = RetrofitFactory.retrofit
        val apiService = retrofit.create(ApiService::class.java)
        return apiService.getProfile(user);
    }

}