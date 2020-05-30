package by.tms.domain.repositories


import by.tms.data.di.DaggerAppComponent
import by.tms.data.network.CovidAPI
import by.tms.data.network.models.CovidResponse
import io.reactivex.Single
import javax.inject.Inject

class CountriesRepositoryImpl: CountriesRepository {
    @Inject
    lateinit var retrofitCovid: CovidAPI
    override fun getCovidCountries(): Single<CovidResponse> {
        val component = DaggerAppComponent.create()
        retrofitCovid = component.getRetrofitCovid()

        return retrofitCovid.getSummary()
    }
}