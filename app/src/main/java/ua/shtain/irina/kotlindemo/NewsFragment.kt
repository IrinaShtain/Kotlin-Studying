package ua.shtain.irina.kotlindemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.shtain.irina.kotlindemo.commons.inflate
import kotlinx.android.synthetic.main.news_fragment.*
import ua.shtain.irina.kotlindemo.commons.RedditNewsItem
import ua.shtain.irina.kotlindemo.commons.adapters.NewsAdapter

/**
 * Created by Irina Shtain on 19.01.2018.
 */
class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        container?.inflate(R.layout.news_fragment)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvNewsList.setHasFixedSize(true)
        rvNewsList.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            val news = (1..10).map {
                RedditNewsItem(
                        "author$it",
                        "Title $it",
                        it, // number of comments
                        1457207701L - it * 200, // time
                        "http://lorempixel.com/200/200/technics/$it", // image url
                        "url"
                )
            }
            (rvNewsList.adapter as NewsAdapter).addNews(news)
                  }
    }

    private fun initAdapter() {
        if (rvNewsList.adapter == null) {
            rvNewsList.adapter = NewsAdapter()
            }
    }
}