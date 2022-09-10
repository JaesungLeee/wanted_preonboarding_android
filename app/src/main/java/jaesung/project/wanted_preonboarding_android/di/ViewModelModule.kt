package jaesung.project.wanted_preonboarding_android.di

import jaesung.project.wanted_preonboarding_android.ui.category.CategoryViewModel
import jaesung.project.wanted_preonboarding_android.ui.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NewsViewModel(get()) }
    viewModel { CategoryViewModel(get(), get())}

}