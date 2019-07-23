package com.gmail.mrkondakovda.reactwallpaperabyssapi.sample

import android.graphics.Bitmap
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import com.gmail.mrkondakovda.reactwallpaperabyssapi.ReactWallpaperAbyssAPI
import com.gmail.mrkondakovda.reactwallpaperabyssapi.api.WallpaperInfo
import com.gmail.mrkondakovda.reactwallpaperabyssapi.responses.WallpapersResponse
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxAdapterView
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RxAppCompatActivity() {

    private val api = ReactWallpaperAbyssAPI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val auth = resources.getString(R.string.api_key)

        if (auth.isEmpty())
            throw SecurityException("auth key empty, set api key in strings.xml")

        RxAdapterView.itemClicks(wallpapers).subscribe { pos ->
            val wallpaperInfo = wallpapers.adapter.getItem(pos) as WallpaperInfo
            requestImage(api.getData(wallpaperInfo.urlImage))
        }

        RxView.clicks(get_random).subscribe {
            requestWallpapers(api.random(auth))
        }

        RxView.clicks(get_highest_rated).subscribe {
            requestWallpapers(api.highestRated(auth))
        }

        RxView.clicks(get_newest).subscribe {
            requestWallpapers(api.newest(auth))
        }

    }

    private fun requestWallpapers(source: Observable<WallpapersResponse>) {
        updateWallpapersDownloadProgress(true)

        source.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .compose(bindToLifecycle())
            .subscribe { result ->
                if (result.success) result.wallpapersInfoList?.let { wallpapers.adapter = WallpapersAdapter(this, it) }
                updateWallpapersDownloadProgress(false)
            }
    }

    private fun updateWallpapersDownloadProgress(show: Boolean) {
        wallpapers_progress.visibility = if (show) View.VISIBLE else View.GONE
        wallpapers.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun requestImage(source: Observable<Bitmap?>) {

        updateImageDownloadProgress(true)

        source.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .compose(bindToLifecycle())
            .map(::resizeBitmap)
            .subscribe { result ->
                image.setImageBitmap(result)
                updateImageDownloadProgress(false)
            }
    }

    private fun updateImageDownloadProgress(show: Boolean) {
        image_progress.visibility = if (show) View.VISIBLE else View.GONE
        image.visibility = if (show) View.GONE else View.VISIBLE

    }

    private fun resizeBitmap(image: Bitmap): Bitmap {
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)

        val maxWidth = metrics.widthPixels
        val maxHeight = (metrics.heightPixels * 0.5).toInt()


        val ratioBitmap = image.width.toFloat() / image.height.toFloat()
        val ratioMax = maxWidth.toFloat() / maxHeight.toFloat()

        var finalWidth = maxWidth
        var finalHeight = maxHeight

        if (ratioMax > ratioBitmap) {
            finalWidth = (maxHeight.toFloat() * ratioBitmap).toInt()
        } else {
            finalHeight = (maxWidth.toFloat() / ratioBitmap).toInt()
        }

        return Bitmap.createScaledBitmap(image, finalWidth, finalHeight, false)

    }
}
