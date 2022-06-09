package com.example.jokeschucknorris.jokes_list.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeschucknorris.R
import com.example.jokeschucknorris.jokes_list.domain.use_case.GetRandomJokes
import com.example.jokeschucknorris.jokes_list.presentation.util.UiEvent
import com.example.jokeschucknorris.jokes_list.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val getRandomJokes: GetRandomJokes
): ViewModel() {

    var state by mutableStateOf(JokesState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getJokes() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                jokesList = emptyList()
            )

            getRandomJokes().onSuccess { jokes ->
                    state = state.copy(
                        jokesList = jokes,
                        isLoading = false,
                    )
                }
                .onFailure {
                    state = state.copy(isLoading = false)
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.error_something_went_wrong)
                        )
                    )
                }
        }
    }
}