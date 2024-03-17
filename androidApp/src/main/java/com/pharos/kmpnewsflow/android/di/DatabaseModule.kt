package com.pharos.kmpnewsflow.android.di

import com.pharos.kmpnewsflow.db.DatabaseDriverFactory
import com.pharos.kmpnewsflow.db.NewsFlowDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { DatabaseDriverFactory(androidContext()).createDriver() }

    single { NewsFlowDatabase(get()) }
}