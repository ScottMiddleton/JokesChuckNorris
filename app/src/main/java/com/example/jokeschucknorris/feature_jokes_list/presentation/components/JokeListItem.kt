package com.example.jokeschucknorris.feature_jokes_list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.jokeschucknorris.feature_jokes_list.domain.model.Joke

@Composable
fun JokeListItem(joke: Joke) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(4.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.surface)
    ) {
        Text(text = joke.jokeStr, modifier = Modifier.fillMaxWidth().padding(20.dp, 10.dp))
    }
}