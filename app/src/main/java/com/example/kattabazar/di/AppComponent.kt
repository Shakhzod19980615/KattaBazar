package com.example.kattabazar.di

import android.app.Application
import com.example.kattabazar.app.DemoApplication
import com.example.kattabazar.di.networkmodule.NetworkModule
import com.example.kattabazar.ui.fragments.CartFragment
import com.example.kattabazar.ui.fragments.HomeFragment
import com.example.kattabazar.ui.fragments.ProfileFragment
import com.example.kattabazar.ui.fragments.SearchFragment
import com.example.restaurant_test.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: CartFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: ProfileFragment)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
    companion object {
        private var instance: AppComponent? = null
        lateinit var application: Application

        fun create(application: DemoApplication):AppComponent{
            instance = DaggerAppComponent.factory().create(application)
            return instance!!
        }

        fun get(): AppComponent {
            return requireNotNull(instance) {"AppComponent  must be initialized"}
        }

    }

}