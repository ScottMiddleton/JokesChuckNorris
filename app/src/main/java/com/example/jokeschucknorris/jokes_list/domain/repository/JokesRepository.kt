package com.example.jokeschucknorris.jokes_list.domain.repository

import com.example.jokeschucknorris.jokes_list.data.remote.dto.JokeDto
import kotlinx.coroutines.flow.Flow

interface JokesRepository {
    fun getRandomJokes(number: String): Flow<JokeDto>
}