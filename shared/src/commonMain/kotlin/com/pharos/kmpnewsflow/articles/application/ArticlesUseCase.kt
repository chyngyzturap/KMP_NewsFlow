package com.pharos.kmpnewsflow.articles.application

import com.pharos.kmpnewsflow.articles.data.ArticleRaw
import com.pharos.kmpnewsflow.articles.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase (private val repository: ArticlesRepository) {

    suspend fun getArticles(isForceRefresh: Boolean): List<Article>{
        val articleRaw = repository.getArticles(isForceRefresh)
        return mapArticles(articleRaw)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>): List<Article> = articleRaw.map { raw ->
        Article(
            raw.title,
            raw.description ?: "Click to find out more",
            getDaysAgoString(raw.publishedAt),
            raw.urlToImage ?: "https://media.licdn.com/dms/image/D4E16AQED6vTQFGHgKA/profile-displaybackgroundimage-shrink_350_1400/0/1692883432429?e=1715817600&v=beta&t=UZgeUj1hKB4fRdqkMnMhhEOZospmao-YoYmg6F_DM8U"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}