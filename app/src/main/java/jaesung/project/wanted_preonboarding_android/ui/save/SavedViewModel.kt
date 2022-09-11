package jaesung.project.wanted_preonboarding_android.ui.save

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.domain.usecase.GetSavedNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedViewModel(private val getSavedNewsUseCase: GetSavedNewsUseCase) : ViewModel() {

    private val _savedNews = MutableStateFlow<List<News>>(emptyList())
    val savedNews: StateFlow<List<News>> = _savedNews.asStateFlow()

    fun loadSavedNews() {
        viewModelScope.launch {
            runCatching { getSavedNewsUseCase() }
                .onSuccess {
                    it.collect { savedNews ->
                        _savedNews.value = savedNews.map { savedNews ->
                            News(
                                author = savedNews.author,
                                title = savedNews.title,
                                description = savedNews.description,
                                newsUrl = savedNews.newsUrl,
                                imageUrl = savedNews.imageUrl,
                                publishedDate = savedNews.publishedAt,
                                content = savedNews.content,
                                isSaved = savedNews.isSaved
                            )
                        }
                    }
                }
        }
    }


}