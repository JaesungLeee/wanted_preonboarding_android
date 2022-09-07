package jaesung.project.wanted_preonboarding_android.data.network

import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.util.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getBBCTopHeadlineNews(
        @Query("sources") source: String
    ): ResponseWrapper<List<Article>>

    @GET("top-headlines")
    suspend fun getCategoryHeadlineNews(
        @Query("country") country: String = "us",
        @Query("category") category: String
    ): ResponseWrapper<List<Article>>
}