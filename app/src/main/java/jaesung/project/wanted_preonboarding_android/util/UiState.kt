package jaesung.project.wanted_preonboarding_android.util

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: List<T>) : UiState<T>()
    data class Error(val error: String? = null) : UiState<Nothing>()
}