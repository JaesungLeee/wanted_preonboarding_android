package jaesung.project.wanted_preonboarding_android.domain.repository

import jaesung.project.wanted_preonboarding_android.data.model.SavedNews
import kotlinx.coroutines.flow.Flow

interface SavedNewsRepository {

    fun getSavedNews(): Flow<List<SavedNews>>

    fun deleteNews(title: String): Flow<Boolean>

    fun insertNews(news: SavedNews): Flow<Boolean>
}