package jaesung.project.wanted_preonboarding_android.domain.usecase

import jaesung.project.wanted_preonboarding_android.data.model.SavedNews
import jaesung.project.wanted_preonboarding_android.domain.repository.SavedNewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val savedNewsRepository: SavedNewsRepository) {
    operator fun invoke(): Flow<List<SavedNews>> {
        return savedNewsRepository.getSavedNews()
    }
}