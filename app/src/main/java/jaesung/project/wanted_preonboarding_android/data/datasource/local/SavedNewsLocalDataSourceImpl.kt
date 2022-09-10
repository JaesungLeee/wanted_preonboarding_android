package jaesung.project.wanted_preonboarding_android.data.datasource.local

import jaesung.project.wanted_preonboarding_android.data.datasource.source.SavedNewsDataSource
import jaesung.project.wanted_preonboarding_android.data.db.NewsDao
import jaesung.project.wanted_preonboarding_android.data.model.SavedNews

class SavedNewsLocalDataSourceImpl(private val dao: NewsDao) : SavedNewsDataSource {

    override suspend fun getSavedNews(): List<SavedNews> {
        return dao.getSavedNews()
    }

    override suspend fun insertNews(news: SavedNews) {
        return dao.insertNews(news)
    }

    override suspend fun deleteNews(news: SavedNews) {
        return dao.deleteNews(news)
    }
}