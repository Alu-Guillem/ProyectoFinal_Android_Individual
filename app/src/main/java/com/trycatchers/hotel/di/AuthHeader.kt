package com.trycatchers.hotel.di

import android.util.Log
import com.trycatchers.hotel.data.repositories.SessionRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Provider // <--- IMPORTANTE: Asegúrate de este import

class AuthHeader @Inject constructor(
    private val sessionRepositoryProvider: Provider<SessionRepository>
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val token = sessionRepositoryProvider.get().getTokenFromPrefs()

        Log.d("AUTH_HEADER", "Token enviado en header: $token")
        Log.d("AUTH_HEADER", "URL de la petición: ${chain.request().url}")
        token?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}