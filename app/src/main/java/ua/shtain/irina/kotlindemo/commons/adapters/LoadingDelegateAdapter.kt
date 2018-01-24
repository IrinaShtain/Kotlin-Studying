package ua.shtain.irina.kotlindemo.commons.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ua.shtain.irina.kotlindemo.R
import ua.shtain.irina.kotlindemo.commons.inflate

/**
 * Created by Irina Shtain on 24.01.2018.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))

}