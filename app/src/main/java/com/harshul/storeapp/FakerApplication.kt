package com.harshul.storeapp

import android.app.Application
import com.harshul.storeapp.data.di.ApplicationComponent
import com.harshul.storeapp.data.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

}