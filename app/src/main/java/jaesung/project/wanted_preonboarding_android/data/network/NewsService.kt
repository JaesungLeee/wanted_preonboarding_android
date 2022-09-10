package jaesung.project.wanted_preonboarding_android.data.network

import jaesung.project.wanted_preonboarding_android.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("country") country: String = "us",
        @Query("category") category: String? = null
    ): NewsResponse
}