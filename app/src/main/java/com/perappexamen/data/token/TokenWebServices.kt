package com.perappexamen.data.token

import com.perappexamen.data.RestConstant
import com.perappexamen.data.token.model.TokenModel
import com.perappexamen.data.token.request.TokenRequest
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST

interface TokenWebServices {

    @POST(RestConstant.ENDPOINT_TOKEN)
    fun requestAccessToken(@Body request: TokenRequest): Call<TokenModel>
}
