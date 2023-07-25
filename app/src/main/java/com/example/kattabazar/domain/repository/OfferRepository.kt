package com.example.kattabazar.domain.repository

import com.example.kattabazar.domain.model.OffersListModel

interface OfferRepository {

    suspend fun  getOfferList() :OffersListModel
}