package com.example.jokeschucknorris.feature_jokes_list.data.repository

import com.example.jokeschucknorris.feature_jokes_list.data.remote.JokesApi
import com.example.jokeschucknorris.feature_jokes_list.data.remote.invalidJokesResponse
import com.example.jokeschucknorris.feature_jokes_list.data.remote.malformedRandomJokesResponse
import com.example.jokeschucknorris.feature_jokes_list.data.remote.validRandomJokesResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class JokesRepositoryImplTest {

    private lateinit var repository: JokesRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: JokesApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

        api = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(JokesApi::class.java)

        repository = JokesRepositoryImpl(api = api)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `get random jokes, valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(validRandomJokesResponse))

        val result = repository.getRandomJokes(9)

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `get random jokes, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(MockResponse().setBody(invalidJokesResponse))

        val result = repository.getRandomJokes(9)

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `get random jokes, malformed response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setBody(malformedRandomJokesResponse)
        )

        val result = repository.getRandomJokes(9)

        assertThat(result.isFailure).isTrue()
    }
}