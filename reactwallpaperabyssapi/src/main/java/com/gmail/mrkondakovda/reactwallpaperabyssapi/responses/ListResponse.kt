package com.gmail.mrkondakovda.reactwallpaperabyssapi.responses

import com.gmail.mrkondakovda.reactwallpaperabyssapi.entities.ListElement
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ListResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean,
    @SerializedName("categories", alternate = ["groups", "sub-categories"])
    @Expose
    val list: List<ListElement>?,
    @SerializedName("error")
    @Expose
    val error: String?
)




