package jaesung.project.wanted_preonboarding_android.di

import jaesung.project.wanted_preonboarding_android.domain.usecase.GetHeadlineNewsUseCase
import jaesung.project.wanted_preonboarding_android.domain.usecase.GetNewsCategoryUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<GetHeadlineNewsUseCase> { GetHeadlineNewsUseCase(get()) }
    single<GetNewsCategoryUseCase> { GetNewsCategoryUseCase(get()) }
}