package com.example.kattabazar.di.response

import kotlinx.serialization.SerialName
@kotlinx.serialization.Serializable
data class AttributesItemResponse(
    @SerialName("name")
    val attributeName : String,
    @SerialName("value")
    val value : String
)
