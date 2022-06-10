package com.example.jokeschucknorris.feature_jokes_list.data.repository

import com.example.jokeschucknorris.feature_jokes_list.domain.model.Joke
import com.example.jokeschucknorris.feature_jokes_list.domain.repository.JokesRepository

class FakeJokesRepository : JokesRepository {
    private val mockJokesList = mutableListOf<Joke>()

    override suspend fun getRandomJokes(number: Int): Result<List<Joke>> {
        for (i in 1..number) {
            mockJokesList.add(Joke("Example joke $i.toString()"))
        }
        return Result.success(mockJokesList)
    }
}