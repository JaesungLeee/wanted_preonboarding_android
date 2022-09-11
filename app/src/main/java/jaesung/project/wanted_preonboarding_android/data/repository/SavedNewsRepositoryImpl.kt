package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.source.SavedNewsDataSource
import jaesung.project.wanted_preonboarding_android.data.model.SavedNews
import jaesung.project.wanted_preonboarding_android.domain.repository.SavedNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SavedNewsRepositoryImpl(
    private val dataSource: SavedNewsDataSource
) : SavedNewsRepository {

    override fun getSavedNews(): Flow<List<SavedNews>> {
        return flow {
            val data = dataSource.getSavedNews()
            emit(data)
        }
    }

    override fun deleteNews(title: String): Flow<Boolean> {
        return flow {
            dataSource.deleteNews(title)
            emit(true)
        }
    }

    override fun insertNews(news: SavedNews): Flow<Boolean> {
        return flow {
            dataSource.insertNews(news)
            emit(true)
        }

    }
}