package com.gmail.mrkondakovda.reactwallpaperabyssapi.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class QueryCount(
    @SerializedName("month_count")
    @Expose
    val monthCount: Int,
    @SerializedName("month_price")
    @Expose
    val monthPrice: Float,
    @SerializedName("last_month_count")
    @Expose
    val lastMonthCount: Int,
    @SerializedName("last_month_price")
    @Expose
    val lastMonthPrice: Float
)