package by.tms.data.di


import by.tms.data.network.CovidAPI
import dagger.Component


@Component(modules = arrayOf(RetrofitModule::class))
interface AppComponent {
    fun getRetrofitCovid(): CovidAPI
}