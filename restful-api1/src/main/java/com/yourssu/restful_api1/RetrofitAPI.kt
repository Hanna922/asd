package com.yourssu.restful_api1

import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*

interface RetrofitAPI {
    @GET("15077586/v1/centers")
    fun getCenters(
            @Query("page") page: Int,
            @Query("perPage") perPage: Int,
            @Query("serviceKey") serviceKey: String
    ): Observable<All>

    companion object {
        private const val BASE_URL_CENTERS_API = "https://api.odcloud.kr/api/"
        const val serviceKey = "NRWPSQkLOW+trNU8A7Cas3oh26gBC9hvk/qyz9YrbQplU85x7NjDq90tAD4nvJt3hrsIvFxL+lGvZeILyDSiOQ=="

        fun createRetrofitApi(): RetrofitAPI {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val headerInterceptor = Interceptor {
                val request = it.request()
                        .newBuilder()
                        .build()
                return@Interceptor it.proceed(request)
            }

            val client = OkHttpClient.Builder()
                    .addInterceptor(headerInterceptor)
                    .addInterceptor(httpLoggingInterceptor)
                    .build()

            return Retrofit.Builder()
                    .baseUrl(BASE_URL_CENTERS_API)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(RetrofitAPI::class.java)
        }
    }
}