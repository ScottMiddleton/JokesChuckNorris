package com.example.jokeschucknorris.jokes_list.data.remote.dto


data class JokeDto (
    val type: String,
    val value: List<Value>
)

data class Value(
    val categories: List<String>,
    val id: Int,
    val joke: String
)