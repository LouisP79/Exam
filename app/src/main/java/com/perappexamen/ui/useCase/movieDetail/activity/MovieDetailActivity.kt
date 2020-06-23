package com.perappexamen.ui.useCase.movieDetail.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.perappexamen.R
import com.perappexamen.data.movie.model.MovieDetailModel
import com.perappexamen.ui.base.activity.BaseActivity
import kotlinx.android.synthetic.main.content_movie_detail.*

class MovieDetailActivity : BaseActivity() {

    companion object{
        const val MOVIE = "movieIntent"
    }

    override val layoutResourceId: Int
        get() = R.layout.activity_movie_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
        setup()
    }

    private fun setup(){
        val detail = intent.getParcelableExtra<MovieDetailModel>(MOVIE)

        if(detail!=null){
            Glide.with(this)
                .load(detail.img)
                .apply(
                    RequestOptions()
                        .placeholder(R.mipmap.ic_launcher_round)
                        .centerCrop())
                .into(imgMovie)

            titleMovie.text = detail.title
            descriptionMovie.text = detail.description
        }
    }
}