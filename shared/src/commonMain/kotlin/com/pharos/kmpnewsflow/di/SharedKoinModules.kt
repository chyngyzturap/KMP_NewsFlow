package com.pharos.kmpnewsflow.di

import com.pharos.kmpnewsflow.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)