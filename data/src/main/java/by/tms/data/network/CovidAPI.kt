package by.tms.data.network

import by.tms.data.network.models.CovidResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CovidAPI {
    @GET("summary")
    fun getSummary(): Single<CovidResponse>
}