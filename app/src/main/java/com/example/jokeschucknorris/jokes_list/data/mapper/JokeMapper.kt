package com.example.jokeschucknorris.jokes_list.data.mapper

import com.example.jokeschucknorris.jokes_list.data.remote.dto.Value
import com.example.jokeschucknorris.jokes_list.domain.model.Joke

fun Value.toJoke(): Joke {
    return Joke(jokeStr = joke)
}