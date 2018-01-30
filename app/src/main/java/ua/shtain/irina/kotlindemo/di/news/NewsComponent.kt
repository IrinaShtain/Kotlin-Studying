package ua.shtain.irina.kotlindemo.di.news

import dagger.Component
import ua.shtain.irina.kotlindemo.NewsFragment
import ua.shtain.irina.kotlindemo.di.AppModule
import ua.shtain.irina.kotlindemo.di.NetworkModule
import javax.inject.Singleton

/**
 * Created by Irina Shtain on 29.01.2018.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}