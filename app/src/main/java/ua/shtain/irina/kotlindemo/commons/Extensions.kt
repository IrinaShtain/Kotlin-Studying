package ua.shtain.irina.kotlindemo.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Irina Shtain on 23.01.2018.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
      return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
    }