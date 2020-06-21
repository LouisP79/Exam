package com.perappexamen.ui.useCase.login.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.perappexamen.data.token.TokenWebServices
import com.perappexamen.data.token.model.TokenModel
import com.perappexamen.data.token.request.TokenRequest
import com.perappexamen.util.repository.RepoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository constructor(private val tokenWebServices: TokenWebServices) {

    fun getToken(tokenRequest: TokenRequest): LiveData<RepoResponse<TokenModel>> {
        val data = MutableLiveData<RepoResponse<TokenModel>>()

        tokenWebServices.requestAccessToken(tokenRequest)
            .enqueue(object: Callback<TokenModel>{
                override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                    data.value = RepoResponse.respond(null, t)
                }

                override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {
                    data.value = RepoResponse.respond(response, null)
                }
            })

        return data
    }
}