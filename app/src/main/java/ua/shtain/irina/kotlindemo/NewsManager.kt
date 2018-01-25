package ua.shtain.irina.kotlindemo

import io.reactivex.Observable
import ua.shtain.irina.kotlindemo.commons.RedditNewsItem
import ua.shtain.irina.kotlindemo.api.RestAPI

/**
 * Created by Irina Shtain on 24.01.2018.
 */
class NewsManager(private val api: RestAPI = RestAPI()) {

    fun getNews(limit: String = "10"): Observable<List<RedditNewsItem>> {
        return Observable.create { subscriber ->
            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val news = response.body()?.data?.children?.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                news?.let { subscriber.onNext(it) }
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}