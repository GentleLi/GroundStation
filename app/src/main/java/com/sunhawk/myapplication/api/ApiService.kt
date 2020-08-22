package com.sunhawk.myapplication.api

import com.sunhawk.myapplication.model.UserProfile
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("users/{user}")
    suspend fun getProfile(@Path("user") user: String): UserProfile

}