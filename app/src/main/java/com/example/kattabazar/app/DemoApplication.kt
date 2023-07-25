package com.example.kattabazar.app

import android.app.Application
import com.example.kattabazar.di.AppComponent

class DemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppComponent.create(this)
    }
}