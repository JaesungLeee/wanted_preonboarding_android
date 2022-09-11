package jaesung.project.wanted_preonboarding_android.data.mapper

import jaesung.project.wanted_preonboarding_android.data.model.NewsResponse
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.ui.common.DateTimeUtil.calculateTime
import jaesung.project.wanted_preonboarding_android.ui.common.DateTimeUtil.dateTimeToMilliSec

object NewsMapper {

    fun mapNewsResponseToNews(newsResponse: NewsResponse): List<News> {
        return newsResponse.articles.map { article ->
            News(
                author = article.newsAuthor ?: "",
                title = article.newsTitle,
                description = article.newsDescription ?: "",
                newsUrl = article.newsUrl,
                imageUrl = article.newsThumbnailImage ?: "",
                publishedDate = calculateTime(dateTimeToMilliSec(article.publishDate)),
                content = article.newsContent ?: "",
                isSaved = 0
            )
        }
    }


}