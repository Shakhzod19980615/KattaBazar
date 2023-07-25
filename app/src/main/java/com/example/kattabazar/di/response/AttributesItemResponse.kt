package com.example.kattabazar.di.response

import kotlinx.serialization.SerialName

data class AttributesItemResponse(
    @SerialName("name")
    val name : String,
    @SerialName("value")
    val value : String
)
