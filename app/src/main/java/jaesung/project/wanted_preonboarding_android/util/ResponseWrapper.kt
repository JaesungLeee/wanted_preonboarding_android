package jaesung.project.wanted_preonboarding_android.util

import com.google.gson.annotations.SerializedName

/**
 * Success
 * status - ok
 * totalResults
 * articles
 *
 * Failed
 * status - error
 * code
 * message
 */
data class ResponseWrapper<T>(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int? = null,
    @SerializedName("articles") val articles: T? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("message") val message: String? = null
)
