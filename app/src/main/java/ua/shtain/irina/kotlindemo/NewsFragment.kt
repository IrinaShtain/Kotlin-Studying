package ua.shtain.irina.kotlindemo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.news_fragment.*
import ua.shtain.irina.kotlindemo.commons.adapters.NewsAdapter
import ua.shtain.irina.kotlindemo.commons.inflate

/**
 * Created by Irina Shtain on 19.01.2018.
 */
class NewsFragment : Fragment() {
    private val newsManager by lazy { NewsManager() }
    var subscriptions = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            container?.inflate(R.layout.news_fragment)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvNewsList.setHasFixedSize(true)
        rvNewsList.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }

    private fun requestNews() {
        subscriptions.add(newsManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (rvNewsList.adapter as NewsAdapter)::addNews,
                        { e: Throwable ->
                            Toast.makeText(this.context, "error " + e.message, Toast.LENGTH_LONG).show()
                        }
                )
        )

    }

    private fun initAdapter() {
        if (rvNewsList.adapter == null) {
            rvNewsList.adapter = NewsAdapter()
        }
    }
}