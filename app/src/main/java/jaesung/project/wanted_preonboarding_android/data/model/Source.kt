package jaesung.project.wanted_preonboarding_android.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Source(
    @SerializedName("id") val newsId: String?,
    @SerializedName("name") val newsName: String
) : Serializable