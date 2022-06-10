package com.example.jokeschucknorris.jokes_list.presentation

sealed class JokeEvent {
    object OnLoadJokes : JokeEvent()
    object OnRefreshJokes: JokeEvent()
}
