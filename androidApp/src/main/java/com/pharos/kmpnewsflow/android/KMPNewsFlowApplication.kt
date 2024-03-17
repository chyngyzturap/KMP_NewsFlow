package com.pharos.kmpnewsflow.android

import android.app.Application
import com.pharos.kmpnewsflow.android.di.viewModelsModule
import com.pharos.kmpnewsflow.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KMPNewsFlowApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@KMPNewsFlowApplication)
            modules(modules)
        }
    }
}