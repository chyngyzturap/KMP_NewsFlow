package com.pharos.kmpnewsflow.articles.data

import com.pharos.kmpnewsflow.articles.data.ArticleRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse (
    @SerialName("status") val status: String,
    @SerialName("totalResults") val results: Int,
    @SerialName("articles") val articles: List<ArticleRaw>
)