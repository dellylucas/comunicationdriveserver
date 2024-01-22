package com.dfl.comunicationdriveserver.di

import com.dfl.comunicationdriveserver.data.repository.DashboardRepository
import com.dfl.comunicationdriveserver.domain.use_case.DashboardInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainActivityModule {

    @Provides
    @ViewModelScoped
    fun getDashboardsUseCase(
        repository: DashboardRepository
    ) = DashboardInteractor(repository)

}