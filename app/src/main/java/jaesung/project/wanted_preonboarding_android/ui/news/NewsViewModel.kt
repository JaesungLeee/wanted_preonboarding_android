package jaesung.project.wanted_preonboarding_android.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.repository.NewsRepository
import jaesung.project.wanted_preonboarding_android.util.Event
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val source = "bbc-news"

    private val _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>> = _error

    private val _newsList = MutableLiveData<List<Article>>()
    val newsList: LiveData<List<Article>> = _newsList

    init {
        loadBBCNews()
    }

    private fun loadBBCNews() {
        viewModelScope.launch {
            try {
                val response = repository.getBBCTopHeadlineNews(source)

                when (response.status) {
                    "ok" -> {
                        _newsList.value = response.articles!!
                    }
                    "error" -> {
                        _error.value = Event(response.status)
                    }
                }
                Timber.d("Success: $response")
            } catch (e: Throwable) {
                Timber.d("Failed: $e")
            }
        }
    }
}