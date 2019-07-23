package com.gmail.mrkondakovda.reactwallpaperabyssapi.responses

import com.gmail.mrkondakovda.reactwallpaperabyssapi.api.WallpaperInfo
import com.gmail.mrkondakovda.reactwallpaperabyssapi.entities.Tag
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WallpaperResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean,
    @SerializedName("wallpaper")
    @Expose
    val wallpaper: WallpaperInfo?,
    @SerializedName("error")
    @Expose
    val error: String?,
    @SerializedName("tags")
    @Expose
    val tags: List<Tag>?
)




