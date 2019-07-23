package com.gmail.mrkondakovda.reactwallpaperabyssapi.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean,
    @SerializedName("count")
    @Expose
    val count: Int?,
    @SerializedName("error")
    @Expose
    val error: String?
)