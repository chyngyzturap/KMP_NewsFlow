package com.pharos.kmpnewsflow.articles.di

import com.pharos.kmpnewsflow.articles.ArticlesService
import com.pharos.kmpnewsflow.articles.ArticlesUseCase
import com.pharos.kmpnewsflow.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}