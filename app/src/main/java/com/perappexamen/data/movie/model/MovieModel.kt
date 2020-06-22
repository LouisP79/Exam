package com.perappexamen.data.movie.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class MovieModel {

    @JsonProperty
    var id: Long = 0

    @JsonProperty
    var detail = MovieDetailModel()

}