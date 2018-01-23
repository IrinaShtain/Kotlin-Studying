package ua.shtain.irina.kotlindemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.shtain.irina.kotlindemo.commons.inflate
import kotlinx.android.synthetic.main.news_fragment.*

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
    }
}