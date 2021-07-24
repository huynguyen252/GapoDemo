package com.ribisoft.gapodemo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_ETHERNET
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities.*
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Email.TYPE_MOBILE
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.ribisoft.gapodemo.BuildConfig
import com.ribisoft.gapodemo.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {

    fun loadGlide(mContext: Context, url: String?, placeholder: Drawable, imageView: ImageView) {
        Glide.with(mContext).load(url).placeholder(placeholder)/*.override(SIZE_ORIGINAL, SIZE_ORIGINAL)*/.into(imageView)
    }

    fun convertStringToTime(dataDate: String?): String? {
        var convTime: String? = null
        val prefix = ""
        val suffix = "trước"
        try {
            @SuppressLint("SimpleDateFormat") val dateFormat =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val pasTime = dateFormat.parse(dataDate)
            val nowTime = Date()
            if (BuildConfig.DEBUG && pasTime == null) {
                error("Assertion failed")
            }
            val dateDiff = nowTime.time - pasTime!!.time
            val second = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour = TimeUnit.MILLISECONDS.toHours(dateDiff)
            val day = TimeUnit.MILLISECONDS.toDays(dateDiff)
            convTime = if (second < 60) {
                //                convTime = second + " giây " + suffix;
                "Vừa xong"
            } else if (minute < 60) {
                "$minute phút $suffix"
            } else if (hour < 24) {
                "$hour giờ $suffix"
            } else if (day >= 7) {
                if (day > 360) {
                    (day / 360).toString() + " năm " + suffix
                } else if (day > 30) {
                    (day / 30).toString() + " tháng " + suffix
                } else {
                    (day / 7).toString() + " tuần " + suffix
                }
            } else {
                "$day ngày $suffix"
            }
        } catch (e: ParseException) {
            e.printStackTrace()
            Log.e("ConvTimeE", e.message!!)
        }
        return convTime
    }

    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(TRANSPORT_WIFI) -> true
                capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when(type) {
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }

}