package by.tms.rxjavaapp.retrofit.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class RetrofitModule {

    @Provides
    fun providerOkHTTPClient(inteceptor: ) : OkHttpClient{
        return OkHttpClient.Builder.addInterceptor().
    }

    @Provides
    fun provaderLoginInterceptor(): HttpLoggingInterceptor

    val loggingInterceptor = HttpLoggingInterceptor()

    @Provides



}