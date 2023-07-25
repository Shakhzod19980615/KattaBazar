package com.example.kattabazar.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kattabazar.domain.interactor.OfferInteractor
import com.example.kattabazar.domain.model.OffersListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfferViewModel @Inject constructor(
    private val offerInteractor: OfferInteractor
): ViewModel() {

    private val offerListLiveData_ : MutableLiveData<OffersListModel>
        = MutableLiveData<OffersListModel>()
    val offerListLiveData : LiveData<OffersListModel> = offerListLiveData_

    fun getOfferList(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result =offerInteractor.getOfferList()
                offerListLiveData_.postValue(result)
            }
        }
    }
}