package com.pharos.kmpnewsflow.di

import app.cash.sqldelight.db.SqlDriver
import com.pharos.kmpnewsflow.db.DatabaseDriverFactory
import com.pharos.kmpnewsflow.db.NewsFlowDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<NewsFlowDatabase> { NewsFlowDatabase(get()) }
}