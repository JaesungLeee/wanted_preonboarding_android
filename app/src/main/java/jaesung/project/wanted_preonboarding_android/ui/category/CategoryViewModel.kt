package jaesung.project.wanted_preonboarding_android.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.wanted_preonboarding_android.data.repository.CategoryRepositoryImpl
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.domain.usecase.GetHeadlineNewsUseCase
import jaesung.project.wanted_preonboarding_android.domain.usecase.GetNewsCategoryUseCase
import jaesung.project.wanted_preonboarding_android.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val getNewsCategoryUseCase: GetNewsCategoryUseCase,
    private val getHeadlineNewsUseCase: GetHeadlineNewsUseCase
) : ViewModel() {

    private val _headlineNews = MutableStateFlow<UiState<News>>(UiState.Loading)
    val headlineNews: StateFlow<UiState<News>> = _headlineNews.asStateFlow()

    fun loadCategory() = getNewsCategoryUseCase.invoke()

    fun loadCategoryHeadlineNews(category: String) {
        viewModelScope.launch {
            runCatching { getHeadlineNewsUseCase(category) }
                .onSuccess { newsList ->
                    newsList.collect {
                        _headlineNews.value = UiState.Success(it)
                    }
                }
                .onFailure {
                    _headlineNews.value = UiState.Error(it.message)
                }
        }
    }

}