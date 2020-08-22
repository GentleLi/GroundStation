package com.sunhawk.groundstation.api

import com.sunhawk.groundstation.model.UserProfile
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("users/{user}")
    suspend fun getProfile(@Path("user") user: String): UserProfile

}