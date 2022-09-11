package jaesung.project.wanted_preonboarding_android.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedNews(
    @PrimaryKey val title: String,
    val author: String,
    val description: String,
    val newsUrl: String,
    val imageUrl: String,
    val publishedAt: String,
    val content: String,
    val isSaved: Int
)
