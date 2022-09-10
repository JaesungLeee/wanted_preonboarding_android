package jaesung.project.wanted_preonboarding_android.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.domain.usecase.GetHeadlineNewsUseCase
import jaesung.project.wanted_preonboarding_android.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsViewModel(private val getHeadlineNewsUseCase: GetHeadlineNewsUseCase) : ViewModel() {
//    private val _error = MutableLiveData<Event<String>>()
//    val error: LiveData<Event<String>> = _error

//    private val _newsList = MutableLiveData<List<Article>>()
//    val newsList: LiveData<List<Article>> = _newsList

    private val _headlineNews = MutableStateFlow<UiState<News>>(UiState.Loading)
    val headlineNews: StateFlow<UiState<News>> = _headlineNews.asStateFlow()

//    fun loadBBCNews() {
//        viewModelScope.launch {
//            try {
//                val response = repository.getHeadlineNews(null)
//
//                when (response.status) {
//                    "ok" -> {
//                        _newsList.value = response.articles!!
//                    }
//                    "error" -> {
//                        _error.value = Event(response.message!!)
//                    }
//                }
//                Timber.d("Success: $response")
//            } catch (e: Throwable) {
//                Timber.d("Failed: $e")
//            }
//        }
//    }

    fun loadHeadlineNews() {
        viewModelScope.launch {
            runCatching { getHeadlineNewsUseCase(null) }
                .onSuccess { newsList ->
                    newsList.collect {
                        Timber.e("$it")
                        _headlineNews.value = UiState.Success(it)
                    }
                }
                .onFailure {
                    _headlineNews.value = UiState.Error(it.message)
                }
        }
    }
}