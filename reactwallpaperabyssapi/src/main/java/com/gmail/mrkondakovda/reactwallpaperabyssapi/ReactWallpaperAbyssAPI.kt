package com.gmail.mrkondakovda.reactwallpaperabyssapi

import android.graphics.BitmapFactory
import com.gmail.mrkondakovda.reactwallpaperabyssapi.api.WallpaperAbyssAPI
import com.gmail.mrkondakovda.reactwallpaperabyssapi.api.WallpaperInfo
import com.gmail.mrkondakovda.reactwallpaperabyssapi.responses.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.Okio
import java.io.File
import java.util.concurrent.TimeUnit


class ReactWallpaperAbyssAPI {
    private val api = WallpaperAbyssAPI.instance
    private val httpClientInstance: OkHttpClient by lazy {

        OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()

    }


    private fun applyFilter(filter: Filter?, parameters: MutableMap<String, String>) {

        filter?.let {
            it.width?.let { parameters["width"] = it.toString() }
            it.height?.let { parameters["height"] = it.toString() }
            it.operator?.let { parameters["operator"] = it.toString() }
        }
    }

    fun newest(
        auth: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "newest"
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }
        return api.getWallpapers(parameters)
    }


    fun highestRated(
        auth: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "highest_rated"
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }

        return api.getWallpapers(parameters)
    }


    fun byViews(
        auth: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "by_views"
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }

        return api.getWallpapers(parameters)
    }


    fun byFavorites(
        auth: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "by_favorites"
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }

        return api.getWallpapers(parameters)
    }

    fun wallpaperCount(
        auth: String,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "wallpaper_count"
        applyFilter(filter, parameters)

        return api.getCount(parameters)
    }

    fun category(
        auth: String,
        id: Int,
        infoLevel: Int? = null,
        sort: Sort? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "category"
        parameters["id"] = id.toString()
        infoLevel?.let { parameters["info_level"] = it.toString() }
        sort?.let { parameters["sort"] = sort.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }


        return api.getWallpapers(parameters)
    }


    fun categoryCount(
        auth: String,
        id: Int,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "category_count"
        parameters["id"] = id.toString()

        applyFilter(filter, parameters)



        return api.getCount(parameters)
    }

    fun categoryList(
        auth: String
    ): Observable<ListResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "category_list"

        return api.getList(parameters)
    }

    fun collection(
        auth: String,
        id: Int,
        infoLevel: Int? = null,
        sort: Sort? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "collection"
        parameters["id"] = id.toString()
        infoLevel?.let { parameters["info_level"] = it.toString() }
        sort?.let { parameters["sort"] = sort.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }


        return api.getWallpapers(parameters)
    }

    fun collectionCount(
        auth: String,
        id: Int,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "collection_count"
        parameters["id"] = id.toString()

        applyFilter(filter, parameters)



        return api.getCount(parameters)
    }

    fun collectionList(
        auth: String
    ): Observable<ListResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "collection_list"

        return api.getList(parameters)
    }

    fun group(
        auth: String,
        id: Int,
        infoLevel: Int? = null,
        sort: Sort? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "group"
        parameters["id"] = id.toString()
        infoLevel?.let { parameters["info_level"] = it.toString() }
        sort?.let { parameters["sort"] = sort.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }


        return api.getWallpapers(parameters)
    }

    fun groupCount(
        auth: String,
        id: Int,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "group_count"
        parameters["id"] = id.toString()

        applyFilter(filter, parameters)



        return api.getCount(parameters)
    }

    fun groupList(
        auth: String,
        id: Int
    ): Observable<ListResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "group_list"
        parameters["id"] = id.toString()

        return api.getList(parameters)
    }


    fun subCategory(
        auth: String,
        id: Int,
        infoLevel: Int? = null,
        sort: Sort? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "sub_category"
        parameters["id"] = id.toString()
        infoLevel?.let { parameters["info_level"] = it.toString() }
        sort?.let { parameters["sort"] = sort.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }


        return api.getWallpapers(parameters)
    }

    fun subCategoryCount(
        auth: String,
        id: Int,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "sub_category_count"
        parameters["id"] = id.toString()

        applyFilter(filter, parameters)


        return api.getCount(parameters)
    }

    fun subCategoryList(
        auth: String,
        id: Int
    ): Observable<ListResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "sub_category_list"
        parameters["id"] = id.toString()

        return api.getList(parameters)
    }


    fun featured(
        auth: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "featured"
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }
        return api.getWallpapers(parameters)
    }

    fun featuredCount(
        auth: String,
        filter: Filter? = null
    ): Observable<CountResponse> {

        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "featured_count"

        applyFilter(filter, parameters)


        return api.getCount(parameters)
    }

    fun popular(
        auth: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "popular"
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }
        return api.getWallpapers(parameters)
    }

    fun popularCount(
        auth: String,
        filter: Filter? = null
    ): Observable<CountResponse> {

        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "popular_count"

        applyFilter(filter, parameters)


        return api.getCount(parameters)
    }

    fun tag(
        auth: String,
        id: Int,
        infoLevel: Int? = null,
        sort: Sort? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "tag"
        parameters["id"] = id.toString()
        infoLevel?.let { parameters["info_level"] = it.toString() }
        sort?.let { parameters["sort"] = sort.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }


        return api.getWallpapers(parameters)
    }


    fun tagCount(
        auth: String,
        id: Int,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "tag_count"
        parameters["id"] = id.toString()

        applyFilter(filter, parameters)

        return api.getCount(parameters)
    }


    fun user(
        auth: String,
        id: Int,
        infoLevel: Int? = null,
        sort: Sort? = null,
        page: Int? = null,
        filter: Filter? = null,
        checkLast: Boolean? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "user"
        parameters["id"] = id.toString()
        infoLevel?.let { parameters["info_level"] = it.toString() }
        sort?.let { parameters["sort"] = sort.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)
        checkLast?.let { parameters["check_last"] = it.toString() }


        return api.getWallpapers(parameters)
    }

    fun userCount(
        auth: String,
        id: Int,
        filter: Filter? = null
    ): Observable<CountResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "user_count"
        parameters["id"] = id.toString()

        applyFilter(filter, parameters)


        return api.getCount(parameters)
    }


    fun search(
        auth: String,
        term: String,
        infoLevel: Int? = null,
        page: Int? = null,
        filter: Filter? = null
    ): Observable<WallpapersResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "search"
        parameters["term"] = term
        infoLevel?.let { parameters["info_level"] = it.toString() }
        page?.let { parameters["page"] = it.toString() }
        applyFilter(filter, parameters)

        return api.getWallpapers(parameters)
    }

    fun wallpaperInfo(
        auth: String,
        id: Int
    ): Observable<WallpaperResponse> {


        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "wallpaper_info"
        parameters["id"] = id.toString()


        return api.getWallpaper(parameters)
    }

    fun random(
        auth: String,
        count: Int? = null,
        infoLevel: Int? = null
    ): Observable<WallpapersResponse> {

        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "random"
        count?.let { parameters["count"] = it.toString() }
        infoLevel?.let { parameters["info_level"] = it.toString() }

        return api.getWallpapers(parameters)
    }

    fun queryCount(
        auth: String
    ): Observable<QueryCountResponse> {

        val parameters = mutableMapOf<String, String>()

        parameters["auth"] = auth
        parameters["method"] = "query_count"


        return api.getQueryCount(parameters)
    }

    fun downloadImageBitmap(wallpaperInfo: WallpaperInfo) =
        Observable.fromCallable {

            val result = httpClientInstance.newCall(Request.Builder().url(wallpaperInfo.urlImage).build()).execute()

            if (result.isSuccessful) {
                result.body()?.let {
                    val bytes = it.bytes()
                    BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                }
            } else
                throw Exception("Http request result unsuccessful")

        }.subscribeOn(Schedulers.io())

    fun downloadImageBitmapToFile(wallpaperInfo: WallpaperInfo, file: File) =
        Completable.create { emitter ->

            val result = httpClientInstance.newCall(Request.Builder().url(wallpaperInfo.urlImage).build()).execute()

            if (result.isSuccessful) {
                result.body()?.let {

                    val sink = Okio.buffer(Okio.sink(file))
                    it.source().readAll(sink.buffer())
                    sink.flush()
                    emitter.onComplete()

                }
            } else
                emitter.onError(Exception("Http request result unsuccessful"))

        }.subscribeOn(Schedulers.io())


    enum class Operator {
        max,
        equal,
        min
    }

    enum class Sort {
        newest,
        rating,
        views,
        favorites
    }


    data class Filter(
        val width: Int? = null,
        val height: Int? = null,
        val operator: Operator? = null
    )
}