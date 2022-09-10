package jaesung.project.wanted_preonboarding_android.domain.repository

import jaesung.project.wanted_preonboarding_android.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getHeadlineNews(category: String?): Flow<List<News>>
}