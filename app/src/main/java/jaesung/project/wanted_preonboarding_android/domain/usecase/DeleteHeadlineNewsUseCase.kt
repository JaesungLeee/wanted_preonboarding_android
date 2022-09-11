package jaesung.project.wanted_preonboarding_android.domain.usecase

import jaesung.project.wanted_preonboarding_android.domain.repository.SavedNewsRepository
import kotlinx.coroutines.flow.Flow

class DeleteHeadlineNewsUseCase(private val savedNewsRepository: SavedNewsRepository) {
    operator fun invoke(title: String): Flow<Boolean> {
        return savedNewsRepository.deleteNews(title)
    }
}