package com.example.jokeschucknorris.jokes_list.presentation

import com.example.jokeschucknorris.jokes_list.domain.model.Joke

data class JokesState(
    val isLoading: Boolean = false,
    val jokesList: List<Joke> = emptyList()
)