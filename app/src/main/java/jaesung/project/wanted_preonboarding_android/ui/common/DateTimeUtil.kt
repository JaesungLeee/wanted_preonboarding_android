package jaesung.project.wanted_preonboarding_android.ui.common

import android.annotation.SuppressLint
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateTimeUtil {

    @SuppressLint("SimpleDateFormat")
    fun dateTimeToMilliSec(dateTime: String): Long {
        var timeInMilliSeconds: Long = 0
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")  // yyyy-MM-dd'T'HH:mm:ss.SSS'Z'

        try {
            val date = simpleDateFormat.parse(dateTime)
            if (date != null) {
                timeInMilliSeconds = date.time
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        return timeInMilliSeconds
    }

    fun calculateTime(publishedDateTime: Long): String {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
        val currentDateTime = Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis

        val difference = currentDateTime - publishedDateTime
        Timber.e("$difference")
        return when {
            difference < 60000 -> {
                "Recently Published"
            }
            difference < 3600000 -> {
                "${TimeUnit.MILLISECONDS.toMinutes(difference)} minutes ago"
            }
            difference < 86400000 -> {
                "${TimeUnit.MILLISECONDS.toHours(difference)} hours ago"
            }
            difference < 604800000 -> {
                "${TimeUnit.MILLISECONDS.toDays(difference)} days ago"
            }
            else -> {
                "Long time ago"
            }
        }
    }
}