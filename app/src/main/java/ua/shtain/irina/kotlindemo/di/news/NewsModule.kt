package ua.shtain.irina.kotlindemo.di.news

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ua.shtain.irina.kotlindemo.api.NewsAPI
import ua.shtain.irina.kotlindemo.api.NewsRestAPI
import ua.shtain.irina.kotlindemo.api.RedditApi
import javax.inject.Singleton

/**
 * Created by Irina Shtain on 29.01.2018.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI = NewsRestAPI(redditApi)

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi = retrofit.create(RedditApi::class.java)
}