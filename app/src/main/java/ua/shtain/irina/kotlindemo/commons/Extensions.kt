@file:JvmName("ExtensionsUtils")

package ua.shtain.irina.kotlindemo.commons

import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import ua.shtain.irina.kotlindemo.R

/**
 * Created by Irina Shtain on 23.01.2018.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Log.d("myLog", " +" +imageUrl )
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Log.d("myLog", " -" +imageUrl )
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(this)
    }
}