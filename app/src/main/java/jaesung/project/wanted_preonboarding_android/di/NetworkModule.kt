package jaesung.project.wanted_preonboarding_android.di

import jaesung.project.wanted_preonboarding_android.data.network.NewsService
import jaesung.project.wanted_preonboarding_android.util.Constants.API_KEY
import jaesung.project.wanted_preonboarding_android.util.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().addHeader("Authorization", API_KEY).build()
                )
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<NewsService> {
        get<Retrofit>().create(NewsService::class.java)
    }
}