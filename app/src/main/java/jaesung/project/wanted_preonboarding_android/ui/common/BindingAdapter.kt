package jaesung.project.wanted_preonboarding_android.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import jaesung.project.wanted_preonboarding_android.ui.common.DateTimeUtil.calculateTime
import jaesung.project.wanted_preonboarding_android.ui.common.DateTimeUtil.dateTimeToMilliSec

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun setImageUrl(view: AppCompatImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(view)
                .load(imageUrl)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("publishDate")
    fun setPublishDate(view: AppCompatTextView, publishedDateTime: String) {
        view.text = calculateTime(dateTimeToMilliSec(publishedDateTime))
    }
}