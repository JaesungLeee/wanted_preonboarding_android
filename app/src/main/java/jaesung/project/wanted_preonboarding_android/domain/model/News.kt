package jaesung.project.wanted_preonboarding_android.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val author: String,
    val title: String,
    val description: String,
    val newsUrl: String,
    val imageUrl: String,
    val publishedDate: String,
    val content: String,
    val isSaved: Boolean
) : Parcelable
