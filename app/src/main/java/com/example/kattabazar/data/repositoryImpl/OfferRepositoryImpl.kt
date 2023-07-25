package com.example.kattabazar.data.repositoryImpl

import com.example.kattabazar.data.ApiService
import com.example.kattabazar.data.mapper.mapToOfferListModel
import com.example.kattabazar.domain.model.OffersListModel
import com.example.kattabazar.domain.repository.OfferRepository
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
):OfferRepository {
    override suspend fun getOfferList(): OffersListModel {
        return  try {
            val result = apiService.getOfferList()
            result.mapToOfferListModel()
        }catch (e:Exception){
            return  OffersListModel(emptyList())
        }
    }
}