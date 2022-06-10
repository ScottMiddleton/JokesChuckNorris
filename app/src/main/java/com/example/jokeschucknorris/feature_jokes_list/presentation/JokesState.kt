package com.example.jokeschucknorris.feature_jokes_list.presentation

import com.example.jokeschucknorris.feature_jokes_list.domain.model.Joke

data class JokesState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val jokesList: List<Joke> = emptyList()
)