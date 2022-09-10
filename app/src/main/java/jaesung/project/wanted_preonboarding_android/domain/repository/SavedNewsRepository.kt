package jaesung.project.wanted_preonboarding_android.domain.repository

import jaesung.project.wanted_preonboarding_android.data.model.SavedNews

interface SavedNewsRepository {

    suspend fun getSavedNews(): List<SavedNews>

    suspend fun deleteNews(news: SavedNews)

    suspend fun insertNews(news: SavedNews)
}