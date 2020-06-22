package com.perappexamen.di

import com.perappexamen.data.movie.MovieWebServices
import com.perappexamen.data.token.TokenWebServices
import com.perappexamen.ui.useCase.login.repository.LoginRepository
import com.perappexamen.ui.useCase.main.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideLoginRepository(get()) }
    single { provideMainRepository(get()) }
}

fun provideLoginRepository(tokenWebServices: TokenWebServices): LoginRepository {
    return LoginRepository(tokenWebServices)
}

fun provideMainRepository(movieWebServices: MovieWebServices): MainRepository {
    return MainRepository(movieWebServices)
}