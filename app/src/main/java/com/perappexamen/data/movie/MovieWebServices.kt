package com.perappexamen.data.movie

import com.perappexamen.data.RestConstant
import com.perappexamen.data.movie.model.MovieModel
import com.perappexamen.data.pageableObject.Pageable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

const val PAGE = "page"
interface MovieWebServices {

    @GET(RestConstant.ENDPOINT_MOVIES)
    fun movies(@Header("Authorization") token: String,
               @Query(PAGE) page: Int): Call<Pageable<MovieModel>>
}
