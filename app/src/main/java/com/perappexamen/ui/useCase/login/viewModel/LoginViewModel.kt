package com.perappexamen.ui.useCase.login.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.perappexamen.data.token.model.TokenModel
import com.perappexamen.data.token.request.TokenRequest
import com.perappexamen.ui.useCase.login.repository.LoginRepository
import com.perappexamen.util.repository.RepoResponse

class LoginViewModel constructor(private val loginRepository: LoginRepository): ViewModel() {

    fun getToken(request: TokenRequest): LiveData<RepoResponse<TokenModel>> {
        return loginRepository.getToken(request)
    }

}