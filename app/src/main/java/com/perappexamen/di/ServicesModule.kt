package com.perappexamen.di

import com.perappexamen.data.movie.MovieWebServices
import com.perappexamen.data.token.TokenWebServices
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { provideTokenServices(get()) }
    single { provideMovieServices(get()) }
}

fun provideTokenServices(retrofit: Retrofit): TokenWebServices  = retrofit.create(TokenWebServices::class.java)
fun provideMovieServices(retrofit: Retrofit): MovieWebServices  = retrofit.create(MovieWebServices::class.java)

