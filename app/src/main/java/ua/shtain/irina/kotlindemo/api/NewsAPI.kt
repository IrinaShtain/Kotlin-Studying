package ua.shtain.irina.kotlindemo.api

import retrofit2.Call

/**
 * Created by Irina Shtain on 26.01.2018.
 */
interface NewsAPI {
        fun getNews(after: String, limit: String): Call<RedditNewsResponse>
    }