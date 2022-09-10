package jaesung.project.wanted_preonboarding_android.domain.repository

import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory

interface CategoryRepository {

    fun loadCategory(): List<NewsCategory>
}