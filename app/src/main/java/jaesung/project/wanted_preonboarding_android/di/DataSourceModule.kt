package jaesung.project.wanted_preonboarding_android.di

import jaesung.project.wanted_preonboarding_android.data.datasource.local.CategoryLocalDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.datasource.local.SavedNewsLocalDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.datasource.remote.NewsRemoteDataSourceImpl
import jaesung.project.wanted_preonboarding_android.data.datasource.source.CategoryDataSource
import jaesung.project.wanted_preonboarding_android.data.datasource.source.NewsDataSource
import jaesung.project.wanted_preonboarding_android.data.datasource.source.SavedNewsDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<NewsDataSource> { NewsRemoteDataSourceImpl(get()) }
    single<CategoryDataSource> { CategoryLocalDataSourceImpl() }
    single<SavedNewsDataSource> { SavedNewsLocalDataSourceImpl(get()) }
}