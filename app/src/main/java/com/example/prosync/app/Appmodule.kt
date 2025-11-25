package com.example.prosync.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModeule{
    @Provides
    @Singleton
    fun ProvideNoterepo():Noterepo=Dummynoterepo()
}