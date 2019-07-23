package com.gmail.mrkondakovda.reactwallpaperabyssapi.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ListElement(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("url")
    @Expose
    val url: String
)