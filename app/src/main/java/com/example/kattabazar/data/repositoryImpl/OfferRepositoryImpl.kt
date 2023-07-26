package com.example.kattabazar.data.repositoryImpl

import android.util.Log
import com.example.kattabazar.data.ApiService
import com.example.kattabazar.data.mapper.mapToOfferListModel
import com.example.kattabazar.domain.model.OffersListModel
import com.example.kattabazar.domain.repository.OfferRepository
import javax.inject.Inject
import kotlin.math.log

class OfferRepositoryImpl @Inject constructor(
    private val apiService: ApiService,

):OfferRepository {
    override suspend fun getOfferList(): OffersListModel {
        return  try {
            val result = apiService.getOfferList()
            result.mapToOfferListModel()
        }catch (e:Exception){
            Log.e("MyActivity",e.toString())
            return  OffersListModel(emptyList())
        }
    }
}