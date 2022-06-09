package com.example.jokeschucknorris.jokes_list.domain.use_case

import com.example.jokeschucknorris.jokes_list.data.remote.dto.JokeDto
import com.example.jokeschucknorris.jokes_list.domain.Constants.MAX_RANDOM_JOKES
import com.example.jokeschucknorris.jokes_list.domain.Constants.MIN_RANDOM_JOKES
import com.example.jokeschucknorris.jokes_list.domain.repository.JokesRepository

class GetRandomJokes(private val repository: JokesRepository) {
    suspend operator fun invoke(): JokeDto {
        val randomNo = (MIN_RANDOM_JOKES..MAX_RANDOM_JOKES).shuffled().last()
        return repository.getRandomJokes(randomNo.toString())
    }
}