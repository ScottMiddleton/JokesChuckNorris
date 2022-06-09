package com.example.jokeschucknorris.jokes_list.data.repository

import com.example.jokeschucknorris.jokes_list.data.remote.JokesApi
import com.example.jokeschucknorris.jokes_list.data.remote.dto.JokeDto
import com.example.jokeschucknorris.jokes_list.domain.repository.JokesRepository
import kotlinx.coroutines.flow.Flow

class JokesRepositoryImpl(private val api: JokesApi) : JokesRepository {
    override fun getRandomJokes(number: String): Flow<JokeDto> {
        return api.getRandomJokes(number)
    }
}