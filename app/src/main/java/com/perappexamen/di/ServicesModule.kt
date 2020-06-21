package com.perappexamen.di

import com.perappexamen.data.token.TokenWebServices
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { provideTokenServices(get()) }
}

fun provideTokenServices(retrofit: Retrofit): TokenWebServices  = retrofit.create(TokenWebServices::class.java)

