package com.gmail.mrkondakovda.reactwallpaperabyssapi.api


import com.gmail.mrkondakovda.reactwallpaperabyssapi.responses.*
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WallpaperAbyssAPI {

    @GET("api2.0/get.php")
    fun getWallpapers(@QueryMap parameters: Map<String, String>): Observable<WallpapersResponse>

    @GET("api2.0/get.php")
    fun getCount(@QueryMap parameters: Map<String, String>): Observable<CountResponse>

    @GET("api2.0/get.php")
    fun getList(@QueryMap parameters: Map<String, String>): Observable<ListResponse>

    @GET("api2.0/get.php")
    fun getWallpaper(@QueryMap parameters: Map<String, String>): Observable<WallpaperResponse>

    @GET("api2.0/get.php")
    fun getQueryCount(@QueryMap parameters: Map<String, String>): Observable<QueryCountResponse>

    companion object Factory {


        val instance: WallpaperAbyssAPI by lazy {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://wall.alphacoders.com/")
                .build()

            retrofit.create(WallpaperAbyssAPI::class.java)
        }


    }

}
