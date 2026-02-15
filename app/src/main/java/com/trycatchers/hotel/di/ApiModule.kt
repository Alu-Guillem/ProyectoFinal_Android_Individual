package com.trycatchers.hotel.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.trycatchers.hotel.data.api.BookingService
import com.trycatchers.hotel.data.api.RoomService
import com.trycatchers.hotel.data.api.UserService
import com.trycatchers.hotel.utils.ApiConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit =
            Retrofit.Builder()
                    .baseUrl(ApiConfig.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()

    @Singleton
    @Provides
    fun provideBookingService(retrofit: Retrofit): BookingService =
            retrofit.create(BookingService::class.java)

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): UserService =
            retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideRoomService(retrofit: Retrofit): RoomService =
            retrofit.create(RoomService::class.java)
}
