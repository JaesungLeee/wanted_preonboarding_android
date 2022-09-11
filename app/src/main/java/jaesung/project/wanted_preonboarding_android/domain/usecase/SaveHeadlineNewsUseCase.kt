package jaesung.project.wanted_preonboarding_android.domain.usecase

import jaesung.project.wanted_preonboarding_android.data.model.SavedNews
import jaesung.project.wanted_preonboarding_android.domain.repository.SavedNewsRepository
import kotlinx.coroutines.flow.Flow

class SaveHeadlineNewsUseCase(private val savedNewsRepository: SavedNewsRepository) {
    operator fun invoke(news: SavedNews): Flow<Boolean> {
        return savedNewsRepository.insertNews(news)
    }
}