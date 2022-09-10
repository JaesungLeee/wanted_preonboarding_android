package jaesung.project.wanted_preonboarding_android.data.datasource.source

import jaesung.project.wanted_preonboarding_android.data.model.SavedNews

interface SavedNewsDataSource {

    suspend fun getSavedNews(): List<SavedNews>

    suspend fun insertNews(news: SavedNews)

    suspend fun deleteNews(news: SavedNews)
}