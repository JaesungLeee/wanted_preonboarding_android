package jaesung.project.wanted_preonboarding_android.data.datasource.local

import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.data.datasource.source.CategoryDataSource
import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory

class CategoryLocalDataSourceImpl : CategoryDataSource {
    override fun loadCategory(): List<NewsCategory> {
        return listOf(
            NewsCategory(
                category = "business",
                categoryImage = R.drawable.img_business
            ),
            NewsCategory(
                category = "entertainment",
                categoryImage = R.drawable.img_entertainment
            ),
            NewsCategory(
                category = "general",
                categoryImage = R.drawable.img_general
            ),
            NewsCategory(
                category = "health",
                categoryImage = R.drawable.img_health
            ),
            NewsCategory(
                category = "science",
                categoryImage = R.drawable.img_science
            ),
            NewsCategory(
                category = "sports",
                categoryImage = R.drawable.img_sports
            ),
            NewsCategory(
                category = "technology",
                categoryImage = R.drawable.img_technology
            ),
        )
    }
}