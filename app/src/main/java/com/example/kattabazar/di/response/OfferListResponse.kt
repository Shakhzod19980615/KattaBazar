package com.example.kattabazar.di.response

import kotlinx.serialization.SerialName


data class OfferListResponse(
    @SerialName("offers")
    val offers : List<OfferItemResponse>
)
