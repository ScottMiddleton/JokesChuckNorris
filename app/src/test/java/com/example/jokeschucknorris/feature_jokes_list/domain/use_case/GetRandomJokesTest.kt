package com.example.jokeschucknorris.feature_jokes_list.domain.use_case

import com.example.jokeschucknorris.feature_jokes_list.data.repository.FakeJokesRepository
import com.example.jokeschucknorris.feature_jokes_list.domain.Constants.MAX_RANDOM_JOKES
import com.example.jokeschucknorris.feature_jokes_list.domain.Constants.MIN_RANDOM_JOKES
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomJokesTest {
    private lateinit var getRandomJokesUseCase: GetRandomJokes
    private lateinit var fakeRepository: FakeJokesRepository

    @Before
    fun setUp() {
        fakeRepository = FakeJokesRepository()
        getRandomJokesUseCase = GetRandomJokes(fakeRepository)
    }

    @Test
    fun `Get jokes success, assert number of jokes is in range`() = runBlocking {
        val result = getRandomJokesUseCase.invoke()

        val listSize = result.getOrNull()?.size

        assertThat(listSize).isAtLeast(MIN_RANDOM_JOKES)
        assertThat(listSize).isAtMost(MAX_RANDOM_JOKES)
    }
}