package com.perappexamen.data.pageableObject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Pageable<T>{

    @JsonProperty
    var data: MutableList<T> = mutableListOf()

    @JsonProperty
    var links = PageableLinks()

    @JsonProperty
    var meta = PageableMeta()

    @JsonProperty
    var status: Int = 0
}