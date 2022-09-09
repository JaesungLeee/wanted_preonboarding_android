package jaesung.project.wanted_preonboarding_android.data.network

import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.model.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("country") country: String = "us",
        @Query("category") category: String? = null
    ): ResponseWrapper<List<Article>>
}