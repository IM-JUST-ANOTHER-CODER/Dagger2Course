package my.project.dagger2.data

import my.project.dagger2.data.models.News
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {

    @GET("news")
    suspend fun news() : List<News>

    @GET("news/{id}")
    suspend fun news(@Path("id") id: String): News
}