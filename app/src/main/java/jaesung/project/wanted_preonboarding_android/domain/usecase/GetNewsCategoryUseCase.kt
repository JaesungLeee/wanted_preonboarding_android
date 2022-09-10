package jaesung.project.wanted_preonboarding_android.domain.usecase

import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory
import jaesung.project.wanted_preonboarding_android.domain.repository.CategoryRepository

class GetNewsCategoryUseCase(private val categoryRepository: CategoryRepository) {
    operator fun invoke(): List<NewsCategory> {
        return categoryRepository.loadCategory()
    }
}