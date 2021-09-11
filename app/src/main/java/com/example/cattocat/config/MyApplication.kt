package com.example.cattocat.config

import android.app.Application
import com.naver.maps.map.NaverMapSdk
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

//앱 실행 시에 한 번 실행됨
class MyApplication : Application(){
    val NAVER_CEOCODING_URL = "https://naveropenapi.apigw.ntruss.com/"

    companion object{
        lateinit var naverRetrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("hrli0edo76")
    }


    private fun initNaverGeocodingRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(NaverMapInterceptor())
            .build()

        naverRetrofit = Retrofit.Builder()
            .baseUrl(NAVER_CEOCODING_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    class NaverMapInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val origin = chain.request()
            val request = origin.newBuilder()
                .addHeader("X-NCP-APIGW-API-KEY-ID", "hrli0edo76")
                .addHeader("X-NCP-APIGW-API-KEY", "PCDNFB9jx5sHgVq15IFSAm7Hg03HnPldr8n4iqOJ")
                .build()

            return chain.proceed(request)
        }
    }
}