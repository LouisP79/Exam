package com.perappexamen.ui.useCase.main.fragment

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.perappexamen.R
import com.perappexamen.ui.base.fragment.BaseFragment
import com.perappexamen.ui.useCase.main.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : BaseFragment() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_movie_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setup()
    }

    private fun setup(){
        val detail = (activity as MainActivity).viewModel.movieDetailModel

        if(detail!=null){
            Glide.with(requireContext())
                .load(detail.img)
                .apply(
                    RequestOptions()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .centerCrop())
                .into(img)

            title.text = detail.title
            description.text = detail.description
        }
    }

}
