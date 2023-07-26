package com.example.kattabazar.data.mapper

import com.example.kattabazar.di.response.AttributesItemResponse
import com.example.kattabazar.di.response.OfferItemResponse
import com.example.kattabazar.di.response.OfferListResponse
import com.example.kattabazar.domain.model.AttributesItemModel
import com.example.kattabazar.domain.model.OfferItemModel
import com.example.kattabazar.domain.model.OffersListModel

fun OfferListResponse.mapToOfferListModel():OffersListModel{
    return OffersListModel(
        offersListModel = offers.map{it.mapToOfferItemModel()}
    )
}

fun OfferItemResponse.mapToOfferItemModel():OfferItemModel{
    return OfferItemModel(
        id = id,
        itemName = itemName,
        brand = brand,
        category = category,
        merchant = merchant,
        attributes = attributes.map { it.mapToAttributesItemModel() },
        image = image
    )
}

fun AttributesItemResponse.mapToAttributesItemModel():AttributesItemModel{
    return  AttributesItemModel(
        name = attributeName,
        value = value
    )
}