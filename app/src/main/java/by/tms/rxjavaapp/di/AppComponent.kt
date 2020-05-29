package by.tms.rxjavaapp.di

import by.tms.rxjavaapp.App
import by.tms.rxjavaapp.BaseActivity
import by.tms.rxjavaapp.retrofit.CovidAPI
import dagger.Component

@Component(modules = arrayOf(RetrofitModule::class))
interface AppComponent {
    fun getRetrofitCovid(): CovidAPI
}
