package com.perappexamen.ui.useCase.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.perappexamen.data.movie.model.MovieModel
import com.perappexamen.data.pageableObject.Pageable
import com.perappexamen.ui.useCase.main.repository.MainRepository
import com.perappexamen.util.repository.RepoResponse

class MainViewModel constructor(private val mainRepository: MainRepository): ViewModel() {

    fun getMovies(token: String, page: Int): LiveData<RepoResponse<Pageable<MovieModel>>> {
        return mainRepository.getMovies(token, page)
    }

}