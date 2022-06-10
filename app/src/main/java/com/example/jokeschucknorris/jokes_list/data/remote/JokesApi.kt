package com.example.jokeschucknorris.jokes_list.data.remote

import com.example.jokeschucknorris.jokes_list.data.remote.dto.JokeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JokesApi {

    @GET("random/{number}")
    suspend fun getRandomJokes (
        @Path("number") number: String,
        @Query("exclude") exclude: List<String> = listOf("explicit"),
        @Query("escape") escape: String = "javascript"
    ): JokeDto

    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/"
    }
}