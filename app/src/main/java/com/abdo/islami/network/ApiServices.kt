package com.abdo.islami.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("radio_ar.json")
    fun fetRadiosDataFromApi(): Call<RadioResponse>
}