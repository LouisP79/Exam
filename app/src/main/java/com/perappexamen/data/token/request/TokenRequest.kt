package com.perappexamen.data.token.request

import com.fasterxml.jackson.annotation.JsonProperty

class TokenRequest(@field:JsonProperty var email: String,
                   @field:JsonProperty var password: String)