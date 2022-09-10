package jaesung.project.wanted_preonboarding_android.domain.usecase

import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetHeadlineNewsUseCase(private val repository: NewsRepository) {
    operator fun invoke(category: String?): Flow<List<News>> {
        return repository.getHeadlineNews(category)
    }
}