package ua.shtain.irina.kotlindemo

import io.reactivex.Observable
import ua.shtain.irina.kotlindemo.commons.RedditNewsItem
import ua.shtain.irina.kotlindemo.api.RestAPI
import ua.shtain.irina.kotlindemo.commons.RedditNews

/**
 * Created by Irina Shtain on 24.01.2018.
 */
class NewsManager(private val api: RestAPI = RestAPI()) {

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