package com.example.jokeschucknorris.jokes_list.data.repository

import com.example.jokeschucknorris.jokes_list.data.mapper.toJoke
import com.example.jokeschucknorris.jokes_list.data.remote.JokesApi
import com.example.jokeschucknorris.jokes_list.domain.model.Joke
import com.example.jokeschucknorris.jokes_list.domain.repository.JokesRepository

class JokesRepositoryImpl(private val api: JokesApi) : JokesRepository {
    override suspend fun getRandomJokes(number: String): Result<List<Joke>> {
        return try {
            val jokeDto = api.getRandomJokes(number)

            if (jokeDto.type == "success") {
                Result.success(jokeDto.value.map {
                    it.toJoke()
                })
            } else {
                Result.failure(Exception())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}