package com.example.restaurant_test.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kattabazar.di.annotation.ViewModelKey
import com.example.kattabazar.ui.viewmodels.OfferViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(OfferViewModel::class)
    fun categoryViewModel(viewModel: OfferViewModel) : ViewModel

}