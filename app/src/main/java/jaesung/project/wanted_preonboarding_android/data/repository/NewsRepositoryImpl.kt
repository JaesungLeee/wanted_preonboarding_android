package jaesung.project.wanted_preonboarding_android.data.repository

import jaesung.project.wanted_preonboarding_android.data.datasource.source.NewsDataSource
import jaesung.project.wanted_preonboarding_android.data.mapper.NewsMapper
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(private val dataSource: NewsDataSource) : NewsRepository {
    override fun getHeadlineNews(category: String?): Flow<List<News>> {
        return flow {
            val data = NewsMapper.mapNewsResponseToNews(dataSource.getHeadlineNews(category))
            emit(data)
        }
    }
}