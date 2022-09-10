package jaesung.project.wanted_preonboarding_android.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.util.Event
import kotlinx.coroutines.launch

//class CategoryNewsViewModel(private val repository: CategoryNewsRepository) : ViewModel() {
//
//    private var _category: String = ""
//    var category: String = _category
//        set(value) {
//            _category = value
//            field = value
//        }
//
//    private val _newsCount: MutableLiveData<String> = MutableLiveData<String>()
//    val newsCount: LiveData<String> = _newsCount
//
//    private val _newsList: MutableLiveData<List<Article>> = MutableLiveData<List<Article>>()
//    val newsList: LiveData<List<Article>> = _newsList
//
//    private val _error = MutableLiveData<Event<String>>()
//    val error: LiveData<Event<String>> = _error
//
//
//    fun loadCategoryHeadlines() {
//        viewModelScope.launch {
//            val response = repository.loadCategoryNews(_category)
//
//            when (response.status) {
//                "ok" -> {
//                    _newsCount.value = response.totalResults.toString()
//                    _newsList.value = response.articles!!
//                }
//                "error" -> {
//                    _newsList.value = emptyList()
//                    _error.value = Event(response.message!!)
//                }
//            }
//        }
//    }
//}