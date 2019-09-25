package com.codigo.glory.app

import android.app.Application
import com.airbnb.epoxy.Carousel
import com.codigo.glory.app.di.appModule
import com.codigo.glory.app.di.dataModule
import com.codigo.glory.app.di.databaseModule
import com.codigo.glory.app.di.interactorModule
import com.codigo.glory.app.di.mapperModule
import com.codigo.glory.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * Created by khunzohn on 2019-09-11 at Codigo
 */
class GloryApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Carousel.setDefaultGlobalSnapHelperFactory(null)

        startKoin {
            androidLogger()
            androidContext(this@GloryApp)
            loadKoinModules(
                listOf(
                    appModule, databaseModule,
                    dataModule, interactorModule,
                    mapperModule, viewModelModule
                )
            )
        }
    }
}