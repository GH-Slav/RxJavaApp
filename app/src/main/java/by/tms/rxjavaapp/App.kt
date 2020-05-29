package by.tms.rxjavaapp

import android.app.Application
import by.tms.rxjavaapp.di.AppComponent
import by.tms.rxjavaapp.di.DaggerAppComponent

class App: Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

    }

    fun getComponent(): AppComponent {
        return appComponent
    }
}