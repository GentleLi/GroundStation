package com.sunhawk.groundstation.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {

    private val retrofit: Retrofit
    private val okHttpClient: OkHttpClient = OkHttpClient()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    companion object {
        private val retrofitFactory = RetrofitFactory()
        val retrofit: Retrofit get() = retrofitFactory.retrofit;
    }

}