package by.tms.domain.repositories

import by.tms.data.network.models.CovidResponse
import io.reactivex.Single

interface CountriesRepository {
    fun getCovidCountries(): Single<CovidResponse>
}