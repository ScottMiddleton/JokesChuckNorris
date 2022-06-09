package com.example.jokeschucknorris.jokes_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeschucknorris.jokes_list.domain.use_case.GetRandomJokes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val getRandomJokes: GetRandomJokes
): ViewModel() {

    fun getJokes() {
        viewModelScope.launch {
            val jokes = getRandomJokes()
            jokes
        }
    }
}