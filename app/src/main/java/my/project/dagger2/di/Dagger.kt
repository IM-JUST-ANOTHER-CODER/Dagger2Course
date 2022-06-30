package my.project.dagger2

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import my.project.dagger2.data.Analytics
import my.project.dagger2.data.NewsRepository
import my.project.dagger2.data.NewsRepositoryImpl
import my.project.dagger2.data.NewsService
import my.project.dagger2.presentation.MainActivity
import my.project.dagger2.presentation.NewsDetailFragment
import retrofit2.Retrofit
import retrofit2.create

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: NewsDetailFragment)
}

@Module(includes = [NetworkModule::class, AppBindModule::class])
object AppModule

@Module
class NetworkModule {
    @Provides
    fun provideNewService(): NewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://androidbroadcast.dev")
            .build()
        return retrofit.create()
    }
}

@Module
interface AppBindModule {
    @Suppress("FunctionName")
    @Binds
    fun bindNewsRepositoryImpl_to_NewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl,
    ): NewsRepository
}