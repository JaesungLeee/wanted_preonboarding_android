package jaesung.project.wanted_preonboarding_android.di

import jaesung.project.wanted_preonboarding_android.data.repository.CategoryRepositoryImpl
import jaesung.project.wanted_preonboarding_android.data.repository.NewsRepositoryImpl
import jaesung.project.wanted_preonboarding_android.data.repository.SavedNewsRepositoryImpl
import jaesung.project.wanted_preonboarding_android.domain.repository.CategoryRepository
import jaesung.project.wanted_preonboarding_android.domain.repository.NewsRepository
import jaesung.project.wanted_preonboarding_android.domain.repository.SavedNewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    single<SavedNewsRepository> { SavedNewsRepositoryImpl(get()) }
}