package com.pharos.kmpnewsflow.articles.presentation

import com.pharos.kmpnewsflow.BaseViewModel
import com.pharos.kmpnewsflow.articles.application.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
): BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState
    
    init {
        getArticles()
    }

    fun getArticles(isForceRefresh: Boolean = false){
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))

            val fetchedArticles = useCase.getArticles(isForceRefresh)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}