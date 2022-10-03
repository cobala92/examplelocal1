package example.android.exam.examplelocal1.data.dataremote.di

import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import example.android.exam.examplelocal1.BuildConfig
import example.android.exam.examplelocal1.data.dataremote.datasource.UserRemoteDataSource
import example.android.exam.examplelocal1.data.dataremote.datasource.UserRemoteDataSourceImpl
import example.android.exam.examplelocal1.data.dataremote.service.ApiService
import example.android.exam.examplelocal1.data.dataremote.utils.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
internal interface DataRemoteModule {

    @Binds
    fun userRemoteDataSource(impl: UserRemoteDataSourceImpl): UserRemoteDataSource

    companion object {
        @Provides
        @Singleton
        fun provideApi(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
            return Retrofit.Builder().baseUrl(ApiConstants.BASE_ENDPOINT).client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
        }

        @Provides
        fun provideOkHttpClient(httpLoginInterceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder().addInterceptor(httpLoginInterceptor).build()
        }

        @Provides
        fun provideHttpLoginInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            return interceptor
        }
    }
}