package com.example.jokeschucknorris.jokes_list.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jokeschucknorris.ui.theme.JokesChuckNorrisTheme

@Composable
fun JokesScreen(viewModel: JokesViewModel = hiltViewModel()){
    viewModel.getJokes()
    Text(text = "Hello World")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokesChuckNorrisTheme {
//        JokesScreen()
    }
}