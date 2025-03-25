package com.foodies.home_data.di

import android.app.Application
import androidx.room.Room
import com.foodies.home_data.local.JournalDatabase
import com.foodies.home_data.remote.OpenFoodApi
import com.foodies.home_data.repository.PostRepositoryImpl
import com.foodies.home_data.repository.JournalRepositoryImpl
import com.foodies.home_domain.repository.PostRepository
import com.foodies.home_domain.repository.JournalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenFoodApi(client: OkHttpClient): OpenFoodApi {
        return Retrofit.Builder()
            .baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideTrackerDatabase(app: Application): JournalDatabase {
        return Room.databaseBuilder(
            app,
            JournalDatabase::class.java,
            "tracker_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTrackerRepository(
        api: OpenFoodApi,
        db: JournalDatabase
    ): JournalRepository {
        return JournalRepositoryImpl(
            dao = db.dao,
            api = api
        )
    }

    @Provides
    @Singleton
    fun providePostRepository(
    ): PostRepository {
        return PostRepositoryImpl()
    }
}