package com.perappexamen.data.pageableObject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class PageableLinks{

    @JsonProperty
    var first: String = ""

    @JsonProperty
    var last: String = ""

    @JsonProperty
    var prev: String? = ""

    @JsonProperty
    var next: String? = ""
}