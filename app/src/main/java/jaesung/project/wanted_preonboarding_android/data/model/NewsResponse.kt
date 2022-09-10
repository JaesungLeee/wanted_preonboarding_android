package jaesung.project.wanted_preonboarding_android.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsResponse(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: String,
    @SerializedName("articles") val articles: List<Article>
)