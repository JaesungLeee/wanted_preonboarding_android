package jaesung.project.wanted_preonboarding_android.di

import jaesung.project.wanted_preonboarding_android.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    single<GetHeadlineNewsUseCase> { GetHeadlineNewsUseCase(get()) }
    single<GetNewsCategoryUseCase> { GetNewsCategoryUseCase(get()) }
    single<SaveHeadlineNewsUseCase> { SaveHeadlineNewsUseCase(get())}
    single<GetSavedNewsUseCase> { GetSavedNewsUseCase(get()) }
    single<DeleteHeadlineNewsUseCase> { DeleteHeadlineNewsUseCase(get()) }
}