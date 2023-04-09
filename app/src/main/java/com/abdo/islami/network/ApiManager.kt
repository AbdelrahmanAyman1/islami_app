package com.abdo.islami.network

import com.abdo.islami.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {

    companion object {
        private var retrofit: Retrofit? = null
        private fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(Constants.RadioApi_BaseURl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }

    fun getApi(): ApiServices {
        return getRetrofitInstance().create(ApiServices::class.java)
    }
}