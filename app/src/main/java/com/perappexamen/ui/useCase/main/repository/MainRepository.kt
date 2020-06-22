package com.perappexamen.ui.useCase.main.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.perappexamen.data.movie.MovieWebServices
import com.perappexamen.data.movie.model.MovieModel
import com.perappexamen.data.pageableObject.Pageable
import com.perappexamen.util.repository.RepoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository constructor(private val movieWebServices: MovieWebServices) {

    val data = MutableLiveData<RepoResponse<Pageable<MovieModel>>>()

    fun getMovies(token: String, page: Int): LiveData<RepoResponse<Pageable<MovieModel>>> {

        movieWebServices.movies(token, page)
            .enqueue(object: Callback<Pageable<MovieModel>>{
                override fun onFailure(call: Call<Pageable<MovieModel>>, t: Throwable) {
                    data.value = RepoResponse.respond(null, t)
                }

                override fun onResponse(call: Call<Pageable<MovieModel>>, response: Response<Pageable<MovieModel>>) {
                    data.value = RepoResponse.respond(response, null)
                }
            })

        return data
    }
}