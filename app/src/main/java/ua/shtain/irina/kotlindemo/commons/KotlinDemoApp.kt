package ua.shtain.irina.kotlindemo.commons

import android.app.Application
import ua.shtain.irina.kotlindemo.di.AppModule
import ua.shtain.irina.kotlindemo.di.news.DaggerNewsComponent
import ua.shtain.irina.kotlindemo.di.news.NewsComponent

/**
 * Created by Irina Shtain on 29.01.2018.
 */
class KotlinDemoApp : Application() {
    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()

        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }
}