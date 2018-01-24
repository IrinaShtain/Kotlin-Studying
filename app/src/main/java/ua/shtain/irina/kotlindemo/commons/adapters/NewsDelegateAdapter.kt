package ua.shtain.irina.kotlindemo.commons.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import ua.shtain.irina.kotlindemo.R
import ua.shtain.irina.kotlindemo.commons.RedditNewsItem
import ua.shtain.irina.kotlindemo.commons.inflate
import kotlinx.android.synthetic.main.news_item.view.*
import ua.shtain.irina.kotlindemo.commons.getFriendlyTime
import ua.shtain.irina.kotlindemo.commons.loadImg

/**
 * Created by Irina Shtain on 24.01.2018.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
           // Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}