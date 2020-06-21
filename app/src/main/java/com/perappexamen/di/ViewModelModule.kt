package com.perappexamen.di

import com.perappexamen.ui.useCase.login.viewModel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}