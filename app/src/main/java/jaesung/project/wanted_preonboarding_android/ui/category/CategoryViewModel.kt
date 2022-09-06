package jaesung.project.wanted_preonboarding_android.ui.category

import androidx.lifecycle.ViewModel
import jaesung.project.wanted_preonboarding_android.data.repository.CategoryRepository

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    fun loadCategory() = repository.loadCategory()


}