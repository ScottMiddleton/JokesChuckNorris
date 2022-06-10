package com.example.jokeschucknorris.feature_jokes_list.domain.di

import com.example.jokeschucknorris.feature_jokes_list.domain.repository.JokesRepository
import com.example.jokeschucknorris.feature_jokes_list.domain.use_case.GetRandomJokes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object JokesListDomainModule {

    @ViewModelScoped
    @Provides
    fun provideGetRandomJokesUseCase (
        repository: JokesRepository
    ): GetRandomJokes {
        return GetRandomJokes (repository)
    }
}