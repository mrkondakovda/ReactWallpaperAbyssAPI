package com.gmail.mrkondakovda.reactwallpaperabyssapi.responses

import com.gmail.mrkondakovda.reactwallpaperabyssapi.entities.QueryCount
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QueryCountResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean,

    @SerializedName("counts")
    @Expose
    val counts: QueryCount
)