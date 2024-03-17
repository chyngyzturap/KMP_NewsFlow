package com.pharos.kmpnewsflow.articles.data

import com.pharos.kmpnewsflow.db.NewsFlowDatabase

class ArticlesDataSource (private val database: NewsFlowDatabase) {

    fun getAllArticles(): List<ArticleRaw> =
        database.newsFlowDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>){
        database.newsFlowDatabaseQueries.transaction {
            articles.forEach {articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = database.newsFlowDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.newsFlowDatabaseQueries.insertArticle(
            title = articleRaw.title,
            desc = articleRaw.description,
            date = articleRaw.publishedAt,
            imageUrl = articleRaw.urlToImage
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ) : ArticleRaw =
        ArticleRaw (
        title = title,
        description = desc,
        publishedAt = date,
        urlToImage = url
    )

}