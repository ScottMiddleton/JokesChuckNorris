package com.example.jokeschucknorris.jokes_list.presentation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jokeschucknorris.jokes_list.presentation.util.UiEvent
import com.example.jokeschucknorris.ui.theme.JokesChuckNorrisTheme
import kotlinx.coroutines.flow.collect

@Composable
fun JokesScreen(
    viewModel: JokesViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    viewModel.getJokes()
    val context = LocalContext.current
    val state = viewModel.state

    LaunchedEffect(scaffoldState.snackbarHostState) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
            }
        }
    }

    Text(text = "Hello World")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokesChuckNorrisTheme {
//        JokesScreen()
    }
}