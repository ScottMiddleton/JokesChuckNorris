package com.example.jokeschucknorris.jokes_list.domain.repository

import com.example.jokeschucknorris.jokes_list.domain.model.Joke

interface JokesRepository {
    suspend fun getRandomJokes(number: String): Result<List<Joke>>
}