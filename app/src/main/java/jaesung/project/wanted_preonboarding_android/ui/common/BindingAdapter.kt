package jaesung.project.wanted_preonboarding_android.ui.common

import android.text.Html
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.ui.common.DateTimeUtil.calculateTime
import jaesung.project.wanted_preonboarding_android.ui.common.DateTimeUtil.dateTimeToMilliSec

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun setImageUrl(view: AppCompatImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(view)
                .load(imageUrl)
                .error(R.drawable.img_not_found)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("publishDate")
    fun setPublishDate(view: AppCompatTextView, publishedDateTime: String) {
        view.text = calculateTime(dateTimeToMilliSec(publishedDateTime))
    }

    @JvmStatic
    @BindingAdapter("imageResource")
    fun setImageResource(view: ShapeableImageView, resId: Int) {
        view.setImageResource(resId)
    }
}