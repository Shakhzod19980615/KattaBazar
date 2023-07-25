package com.example.kattabazar.di.response

import kotlinx.serialization.SerialName

data class OfferItemResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("name")
    val name : String,
    @SerialName("brand")
    val brand : String,
    @SerialName("category")
    val category : String,
    @SerialName("merchant")
    val merchant : String,
    @SerialName("attributes")
    val attributes : List<AttributesItemResponse>,
    @SerialName("image")
    val image : String
)
