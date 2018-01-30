package ua.shtain.irina.kotlindemo.api

import retrofit2.Call
import javax.inject.Inject

/**
 * Created by Irina Shtain on 25.01.2018.
 */
class NewsRestAPI @Inject constructor(private val redditApi: RedditApi) : NewsAPI {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}