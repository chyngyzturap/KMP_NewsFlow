package com.pharos.kmpnewsflow.articles.presentation

import com.pharos.kmpnewsflow.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)

