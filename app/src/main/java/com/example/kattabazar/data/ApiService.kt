package com.example.kattabazar.data

import com.example.kattabazar.di.response.OfferListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("offers")
    suspend fun getOfferList(): OfferListResponse
}