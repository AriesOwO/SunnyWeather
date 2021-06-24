package com.example.sunnyweather.logic.network

import com.safframework.http.interceptor.AndroidLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val client = OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)// 设置请求超时时间
        .writeTimeout(10, TimeUnit.SECONDS)// 设置写入超时时间
        .readTimeout(10, TimeUnit.SECONDS)// 设置读取超时时间
        .addInterceptor(AndroidLoggingInterceptor.build())// 添加打印拦截器
        .retryOnConnectionFailure(true)// 设置出现错误时进行重新连接
        .build();

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}