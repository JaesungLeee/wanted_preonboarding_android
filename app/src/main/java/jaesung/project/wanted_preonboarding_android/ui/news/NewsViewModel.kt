package jaesung.project.wanted_preonboarding_android.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.wanted_preonboarding_android.data.model.SavedNews
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.domain.usecase.DeleteHeadlineNewsUseCase
import jaesung.project.wanted_preonboarding_android.domain.usecase.GetHeadlineNewsUseCase
import jaesung.project.wanted_preonboarding_android.domain.usecase.SaveHeadlineNewsUseCase
import jaesung.project.wanted_preonboarding_android.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsViewModel(
    private val getHeadlineNewsUseCase: GetHeadlineNewsUseCase,
    private val saveHeadlineNewsUseCase: SaveHeadlineNewsUseCase,
    private val deleteHeadlineNewsUseCase: DeleteHeadlineNewsUseCase
) : ViewModel() {
//    private val _error = MutableLiveData<Event<String>>()
//    val error: LiveData<Event<String>> = _error

//    private val _newsList = MutableLiveData<List<Article>>()
//    val newsList: LiveData<List<Article>> = _newsList

    private val _headlineNews = MutableStateFlow<UiState<News>>(UiState.Loading)
    val headlineNews: StateFlow<UiState<News>> = _headlineNews.asStateFlow()

    var isSaved = MutableStateFlow<Int>(0)

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

    fun saveNews(news: News) {
        val savedNews = SavedNews(
            title = news.title,
            author = news.author,
            description = news.description,
            newsUrl = news.newsUrl,
            imageUrl = news.imageUrl,
            publishedAt = news.publishedDate,
            content = news.content,
            isSaved = 1
        )

        viewModelScope.launch {
            runCatching { saveHeadlineNewsUseCase(savedNews) }
                .onSuccess { savedState ->
                    savedState.collect {
                        if (it) {
                            Timber.e("${isSaved.value}")
                            isSaved.value = isSaved.value.plus(1)
                            Timber.e("${isSaved.value}")
                        }
                    }
                }
        }
    }

    fun deleteNews(title: String) {
        viewModelScope.launch {
            runCatching { deleteHeadlineNewsUseCase.invoke(title) }
                .onSuccess { state ->
                    state.collect {
                        if (it) {
                            Timber.e("${isSaved.value}")
                            isSaved.value = isSaved.value.minus(1)
                            Timber.e("${isSaved.value}")
                        }
                    }
                }
        }
    }
}