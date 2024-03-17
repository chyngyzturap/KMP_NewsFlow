package com.pharos.kmpnewsflow.articles.di

import com.pharos.kmpnewsflow.articles.data.ArticlesDataSource
import com.pharos.kmpnewsflow.articles.data.ArticlesRepository
import com.pharos.kmpnewsflow.articles.data.ArticlesService
import com.pharos.kmpnewsflow.articles.application.ArticlesUseCase
import com.pharos.kmpnewsflow.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDataSource(get()) }
    single { ArticlesRepository(get(), get()) }
}