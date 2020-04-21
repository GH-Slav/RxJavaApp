package by.tms.rxjavaapp.retrofit

import io.reactivex.Single
import retrofit2.http.GET

interface CovidAPI {
    @GET("summary")
    fun getSummary(): Single<Covid>
}