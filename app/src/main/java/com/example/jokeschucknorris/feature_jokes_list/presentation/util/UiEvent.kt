package com.example.jokeschucknorris.feature_jokes_list.presentation.util

sealed class UiEvent {
    data class ShowSnackbar(val message: UiText): UiEvent()
}