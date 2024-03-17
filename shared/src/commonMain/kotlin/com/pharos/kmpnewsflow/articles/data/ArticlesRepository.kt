package com.pharos.kmpnewsflow.articles.data

class ArticlesRepository (
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService
) {

    suspend fun getArticles(isForceRefresh: Boolean): List<ArticleRaw>{
        if (isForceRefresh){
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} from the db!")

        if (articlesDb.isEmpty()){
            return fetchArticles()
        }

        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw>{
        val fetchedArticles = articlesService.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}