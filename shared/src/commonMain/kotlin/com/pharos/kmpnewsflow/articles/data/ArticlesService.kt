package com.pharos.kmpnewsflow.articles.data

import com.pharos.kmpnewsflow.articles.data.ArticleRaw
import com.pharos.kmpnewsflow.articles.data.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

//    private val sources = "techcrunch"
    private val country = "us"
    private val category = "business"
    private val apiKey = "2f1eaff1c05d46f4bbffae4b0ac6fa74"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
//            httpClient.get("https://newsapi.org/v2/top-headlines?sources=$sources&apiKey=$apiKey")
              httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
            .body()
        return response.articles
    }
}