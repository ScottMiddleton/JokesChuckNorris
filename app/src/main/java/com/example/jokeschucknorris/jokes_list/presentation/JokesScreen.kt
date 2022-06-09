package com.example.jokeschucknorris.jokes_list.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jokeschucknorris.ui.theme.JokesChuckNorrisTheme

@Composable
fun JokesScreen(){
    Text(text = "Hello World")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokesChuckNorrisTheme {
        JokesScreen()
    }
}