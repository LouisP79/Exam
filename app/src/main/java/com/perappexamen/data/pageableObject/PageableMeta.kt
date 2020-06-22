package com.perappexamen.data.pageableObject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class PageableMeta(){

    @JsonProperty("current_page")
    var currentPage: Int = 0

    @JsonProperty
    var from: Int = 0

    @JsonProperty("last_page")
    var lastPage: Int = 0

    @JsonProperty
    var path: String = ""

    @JsonProperty("per_page")
    var perPage: Int = 0

    @JsonProperty
    var to: Int = 0

    @JsonProperty
    var total: Int = 0
}