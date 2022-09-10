package jaesung.project.wanted_preonboarding_android.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id") val newsId: String?,
    @SerializedName("name") val newsName: String
)