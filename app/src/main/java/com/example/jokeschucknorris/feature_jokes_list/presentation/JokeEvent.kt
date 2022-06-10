package com.example.jokeschucknorris.feature_jokes_list.presentation

sealed class JokeEvent {
    object OnRefreshJokes: JokeEvent()
}
