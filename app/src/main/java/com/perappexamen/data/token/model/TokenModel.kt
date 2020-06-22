package com.perappexamen.data.token.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class TokenModel{

    @JsonProperty
    var status: String = ""

    @JsonProperty
    var data: DataModel = DataModel()
}
