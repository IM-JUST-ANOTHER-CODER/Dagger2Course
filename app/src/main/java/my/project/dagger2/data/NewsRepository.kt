package my.project.dagger2.data

import my.project.dagger2.data.models.News
import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews(newsId: String): News
}

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val analytics: Analytics,
) : NewsRepository {

    override suspend fun getNews(newsId: String): News {
        analytics.trackNewsRequest(newsId)
        return newsService.news(newsId)
    }
}

