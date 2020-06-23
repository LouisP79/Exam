package com.perappexamen.ui.useCase.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.perappexamen.R
import com.perappexamen.data.movie.model.MovieModel
import com.perappexamen.data.pageableObject.Pageable
import com.perappexamen.ui.base.fragment.BaseFragment
import com.perappexamen.ui.useCase.main.activity.MainActivity
import com.perappexamen.ui.useCase.main.adapter.MovieAdapter
import com.perappexamen.ui.useCase.movieDetail.activity.MovieDetailActivity
import com.perappexamen.ui.useCase.movieDetail.activity.MovieDetailActivity.Companion.MOVIE
import com.perappexamen.util.listener.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_movies.*


class MovieFragment : BaseFragment() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_movies

    private lateinit var adapter: MovieAdapter
    private var pageable: Pageable<MovieModel>? = null
    private var page: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup(){
        adapter =  MovieAdapter()
        adapter.setOnDetailClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE, it)
            startActivity(intent)
        }

        val layoutManager = GridLayoutManager(context, 3)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        movies.layoutManager = layoutManager
        movies.adapter = adapter

        movies.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) = loadMoreMovies()
        })

        loadMovies()
    }

    private fun loadMovies() {
        loading.visibility = View.VISIBLE
        (activity as MainActivity).viewModel.getMovies(applicationPreferences.getBearerToken()!!, page)
            .observe(viewLifecycleOwner,
                Observer { response ->
                    when(response){
                        null -> unknownError(null)
                        else ->{
                            if(response.dataResponse != null){
                                if(response.dataResponse.isSuccessful){
                                    pageable = response.dataResponse.body()
                                    adapter.items = pageable!!.data
                                }else errorCode(response.dataResponse.code())
                            }else errorConnection(response.throwable!!)
                        }
                    }
                    loading.visibility = View.GONE
                })
    }

    private fun loadMoreMovies() {
        if (pageable != null && pageable!!.links.next != null){
            page++
            (activity as MainActivity).viewModel.getMovies(applicationPreferences.getBearerToken()!!, page)
        }
    }

}
