package com.example.mvvmarchitecture.di

import com.example.mvvmarchitecture.repository.ILocalDataRepository
import com.example.mvvmarchitecture.repository.IRepository
import com.example.mvvmarchitecture.repository.LocalDataRepository
import com.example.mvvmarchitecture.repository.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(repository: Repository): IRepository

    @Singleton
    @Binds
    abstract fun bindLocalDataRepository(localDataRepository: LocalDataRepository): ILocalDataRepository
}