package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.source.CategoryDataSource
import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory

class CategoryRepository(private val dataSource: CategoryDataSource) {

    fun loadCategory(): List<NewsCategory> {
        return dataSource.loadCategory()
    }
}