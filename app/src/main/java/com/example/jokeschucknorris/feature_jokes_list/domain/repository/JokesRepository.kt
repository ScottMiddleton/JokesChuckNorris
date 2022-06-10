package com.example.jokeschucknorris.feature_jokes_list.domain.repository

import com.example.jokeschucknorris.feature_jokes_list.domain.model.Joke

interface JokesRepository {
    suspend fun getRandomJokes(number: Int): Result<List<Joke>>
}