package com.perappexamen.di

import android.content.Context
import android.os.Build
import com.perappexamen.BuildConfig


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import com.perappexamen.preferences.ApplicationPreferences
import com.perappexamen.util.core.UtilConnectionInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val appModule = module {
    single { provideAppPreference(androidContext()) }
    single { provideJacksonConverterFactory() }
    single { provideHttpInterceptor() }
    single { provideOkHttpClient(get(), get()) }
    single { provideRxJava2CallAdapterFactory() }
    single { provideRetrofit(get(), get(), get()) }
    single { UtilConnectionInterceptor(androidContext()) }
}

//PREFERENCES
fun provideAppPreference(context: Context): ApplicationPreferences {
    return ApplicationPreferences(context)
}

//RETROFIT
//·····································
fun provideJacksonConverterFactory(): JacksonConverterFactory {
    return JacksonConverterFactory.create()
}

fun provideHttpInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
    }
}

fun provideOkHttpClient(interceptor: HttpLoggingInterceptor, connectionInterceptor: UtilConnectionInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(connectionInterceptor)
            .addInterceptor {
                it.proceed(
                        it.request().newBuilder()
                                .header("User-Agent",
                                        "Android ${Build.VERSION.RELEASE}; ${Build.MODEL}")
                                .build()
                )
            }
            .build()
}

fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
    return RxJava2CallAdapterFactory.create()
}

fun provideRetrofit(okHttpClient: OkHttpClient, jacksonConverterFactory: JacksonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE)
            .client(okHttpClient)
            .addConverterFactory(jacksonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
}
//RETROFIT
//·····································
