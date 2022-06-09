package com.example.jokeschucknorris.jokes_list.data.di

import com.example.jokeschucknorris.jokes_list.data.remote.JokesApi
import com.example.jokeschucknorris.jokes_list.data.repository.JokesRepositoryImpl
import com.example.jokeschucknorris.jokes_list.domain.repository.JokesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JokesDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideJokesApi(client: OkHttpClient): JokesApi {
        return Retrofit.Builder()
            .baseUrl(JokesApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideJokesRepository(
        api: JokesApi
    ): JokesRepository {
        return JokesRepositoryImpl(
            api = api
        )
    }
}