package ua.shtain.irina.kotlindemo

import io.reactivex.Observable
import ua.shtain.irina.kotlindemo.api.NewsAPI
import ua.shtain.irina.kotlindemo.commons.RedditNews
import ua.shtain.irina.kotlindemo.commons.RedditNewsItem
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Irina Shtain on 24.01.2018.
 */
@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create { subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body()?.data
                val news = dataResponse?.children?.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse?.after ?: "",
                        dataResponse?.before ?: "",
                        news!!)

                subscriber.onNext(redditNews)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}