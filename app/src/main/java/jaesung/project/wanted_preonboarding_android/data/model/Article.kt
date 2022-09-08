package jaesung.project.wanted_preonboarding_android.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article(
    @SerializedName("source") val source: Source,
    @SerializedName("author") val newsAuthor: String?,
    @SerializedName("title") val newsTitle: String?,
    @SerializedName("description") val newsDescription: String?,
    @SerializedName("url") val newsUrl: String?,
    @SerializedName("urlToImage") val newsThumbnailImage: String?,
    @SerializedName("publishedAt") val publishDate: String?,
    @SerializedName("content") val newsContent: String?
) : Serializable