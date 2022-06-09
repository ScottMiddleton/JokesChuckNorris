package com.example.jokeschucknorris.jokes_list.presentation.util

sealed class UiEvent {
    data class ShowSnackbar(val message: UiText): UiEvent()
}