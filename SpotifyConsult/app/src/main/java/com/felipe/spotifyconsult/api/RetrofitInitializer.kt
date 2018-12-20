package com.felipe.spotifyconsult.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    companion object {
        private const val BASE_URL = "https://api.spotify.com/v1/"

        private fun getBuilder(): Retrofit.Builder {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        }

        private fun getClient(token: String): OkHttpClient {
            return OkHttpClient.Builder().addInterceptor { chain ->
                val request: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()

                chain.proceed(request)
            }.build()
        }

        fun <S> createService(serviceClass: Class<S>): S {
            return getBuilder().build().create(serviceClass)
        }

        fun <S> createService(serviceClass: Class<S>, token: String): S {
            return getBuilder().client(getClient(token)).build().create(serviceClass)
        }

    }
}