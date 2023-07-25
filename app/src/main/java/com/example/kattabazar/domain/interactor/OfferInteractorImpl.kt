package com.example.kattabazar.domain.interactor

import com.example.kattabazar.domain.model.OffersListModel
import com.example.kattabazar.domain.repository.OfferRepository
import javax.inject.Inject

class OfferInteractorImpl  @Inject constructor(
    private val offerRepository : OfferRepository
): OfferInteractor {
    override suspend fun getOfferList(): OffersListModel {
        return offerRepository.getOfferList()
    }
}