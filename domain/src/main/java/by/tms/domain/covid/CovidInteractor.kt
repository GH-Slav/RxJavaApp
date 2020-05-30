package by.tms.domain.covid
import by.tms.data.network.models.CountryResponse
import by.tms.domain.models.Country
import by.tms.domain.repositories.CountriesRepository
import by.tms.domain.repositories.CountriesRepositoryImpl

import io.reactivex.Single

class CovidInteractor {
    lateinit var countriesRepository: CountriesRepository

    fun getAllCountries(): Single<ArrayList<Country>> {
        val list = ArrayList<Country>()
        countriesRepository = CountriesRepositoryImpl()
        return countriesRepository.getCovidCountries().map {
            it.countries.forEach { countryResponse ->
                val url = "https://www.countryflags.io/${countryResponse.countryCode}/flat/64.png"
                countryResponse.countryFlagUrl = url
                list.add(countryConverter(countryResponse))
            }
            list
        }
    }

    private fun countryConverter(resp: CountryResponse): Country {
        return Country(
            resp.country,
            resp.countryCode,
            resp.date,
            resp.newConfirmed,
            resp.newDeaths,
            resp.newRecovered,
            resp.slug,
            resp.totalConfirmed,
            resp.totalDeaths,
            resp.totalRecovered,
            resp.countryFlagUrl
        )
    }
}