package jaesung.project.wanted_preonboarding_android.data.datasource.source

import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory

interface CategoryDataSource {
    fun loadCategory(): List<NewsCategory>
}