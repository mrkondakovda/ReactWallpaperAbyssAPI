package com.gmail.mrkondakovda.reactwallpaperabyssapi.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WallpaperInfo(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("featured")
    @Expose
    val featured: Boolean?,
    @SerializedName("width")
    @Expose
    val width: Int,
    @SerializedName("height")
    @Expose
    val height: Int,
    @SerializedName("file_type")
    @Expose
    val fileType: String,
    @SerializedName("file_size")
    @Expose
    val fileSize: Int,
    @SerializedName("url_image")
    @Expose
    val urlImage: String,
    @SerializedName("url_thumb")
    @Expose
    val urlThumb: String,
    @SerializedName("url_page")
    @Expose
    val urlPage: String,
    @SerializedName("category")
    @Expose
    val category: String?,
    @SerializedName("category_id")
    @Expose
    val categoryId: Int?,
    @SerializedName("sub_category_id")
    @Expose
    val subCategoryId: Int?,
    @SerializedName("user_name")
    @Expose
    val userName: String?,
    @SerializedName("user_id")
    @Expose
    val userId: Int?,
    @SerializedName("collection")
    @Expose
    val collection: String?,
    @SerializedName("collection_id")
    @Expose
    val collectionId: Int?,
    @SerializedName("group")
    @Expose
    val group: String?,
    @SerializedName("group_id")
    @Expose
    val groupId: Int?


)