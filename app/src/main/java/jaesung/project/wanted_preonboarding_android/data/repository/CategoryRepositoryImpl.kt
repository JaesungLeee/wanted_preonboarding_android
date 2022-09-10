package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.source.CategoryDataSource
import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory
import jaesung.project.wanted_preonboarding_android.domain.repository.CategoryRepository

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository {

    override fun loadCategory(): List<NewsCategory> {
        return dataSource.loadCategory()
    }
}