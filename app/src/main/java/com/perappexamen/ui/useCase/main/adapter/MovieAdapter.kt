package com.perappexamen.ui.useCase.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.perappexamen.R
import com.perappexamen.data.movie.model.MovieDetailModel
import com.perappexamen.data.movie.model.MovieModel
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var listener: ((detail: MovieDetailModel)->Unit)? = null

    var items  = mutableListOf<MovieModel>()
        set(value) {
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: MovieModel) = with(itemView) {

            Glide.with(context)
                .load(item.detail.img)
                .apply(RequestOptions()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .centerCrop())
                .into(img)

            title.text = item.detail.title
            movie.setOnClickListener { listener?.invoke(item.detail) }
        }
    }

    fun setOnDetailClickListener(listener: (detail: MovieDetailModel)->Unit){
        this.listener = listener
    }

}

