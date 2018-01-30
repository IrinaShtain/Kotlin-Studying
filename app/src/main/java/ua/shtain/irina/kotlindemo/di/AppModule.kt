package ua.shtain.irina.kotlindemo.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import ua.shtain.irina.kotlindemo.commons.KotlinDemoApp

/**
 * Created by Irina Shtain on 29.01.2018.
 */
@Module
class AppModule(val app: KotlinDemoApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app

}