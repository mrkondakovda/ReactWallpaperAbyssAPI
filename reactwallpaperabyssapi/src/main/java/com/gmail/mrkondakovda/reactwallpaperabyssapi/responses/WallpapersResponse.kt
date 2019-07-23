package com.gmail.mrkondakovda.reactwallpaperabyssapi.responses

import com.gmail.mrkondakovda.reactwallpaperabyssapi.api.WallpaperInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WallpapersResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean,
    @SerializedName("wallpapers")
    @Expose
    val wallpapersInfoList: List<WallpaperInfo>?,
    @SerializedName("error")
    @Expose
    val error: String?
)




