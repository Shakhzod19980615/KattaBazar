package com.example.kattabazar.domain.interactor

import com.example.kattabazar.domain.model.OffersListModel

interface OfferInteractor {
    suspend fun  getOfferList() : OffersListModel
}