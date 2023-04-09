package com.abdo.islami.network

import com.google.gson.annotations.SerializedName

data class RadioResponse(

    @field:SerializedName("Radios")
    val radios: List<RadiosItem?>? = null
)

data class RadiosItem(

    @field:SerializedName("Id")
    val id: String? = null,

    @field:SerializedName("URL")
    val uRL: String? = null,

    @field:SerializedName("Name")
    val name: String? = null
)
