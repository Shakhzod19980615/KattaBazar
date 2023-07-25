package com.example.kattabazar.domain.model

class OfferItemModel(
    val id : Int,
    val name : String,
    val brand : String,
    val category : String,
    val merchant : String,
    val attributes : List<AttributesItemModel>,
    val image :String
)