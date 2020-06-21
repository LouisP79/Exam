package com.perappexamen.di

import com.perappexamen.data.token.TokenWebServices
import com.perappexamen.ui.useCase.login.repository.LoginRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideLoginRepository(get()) }
}

fun provideLoginRepository(tokenWebServices: TokenWebServices): LoginRepository {
    return LoginRepository(tokenWebServices)
}