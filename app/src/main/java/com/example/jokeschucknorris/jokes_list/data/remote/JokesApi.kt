package com.example.jokeschucknorris.jokes_list.data.remote

import com.example.jokeschucknorris.jokes_list.data.remote.dto.JokeDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface JokesApi {

    @GET("random/{number}")
    suspend fun getRandomJokes (
        @Path("number") number: String,
    ): JokeDto

    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/"
    }
}