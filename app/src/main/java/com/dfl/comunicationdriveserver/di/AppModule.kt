package com.dfl.comunicationdriveserver.di

import com.dfl.comunicationdriveserver.data.data_source.IDataSource
import com.dfl.comunicationdriveserver.data.data_source.RemoteDataSource
import com.dfl.comunicationdriveserver.data.repository.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun dashboardRepositoryProvider(
        iDataSource: IDataSource
    ) = DashboardRepository(iDataSource)

    @Provides
    fun mainDataSourceProvider(retrofit: Retrofit): IDataSource = RemoteDataSource(retrofit)

}