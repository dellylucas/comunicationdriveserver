package com.dfl.comunicationdriveserver.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    @Named("URL")
    fun getBaseURL(): String = "http://localhost:3000/user-bff/"


    @Provides
    @Singleton
    fun getRetrofit(@Named("URL") baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .baseUrl(baseUrl)
        .build()

}