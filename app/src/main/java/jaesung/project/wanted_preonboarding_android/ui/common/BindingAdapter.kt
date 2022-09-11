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
    @BindingAdapter("imageResource")
    fun setImageResource(view: ShapeableImageView, resId: Int) {
        view.setImageResource(resId)
    }

    @JvmStatic
    @BindingAdapter("htmlTag")
    fun setHtmlTag(view: AppCompatTextView, source: String?) {
        if (!source.isNullOrEmpty()) {
            view.text = Html.fromHtml(source, Html.FROM_HTML_MODE_COMPACT)
        }
    }

    @JvmStatic
    @BindingAdapter("loadSaveImage")
    fun setLoadSaveImage(view: AppCompatImageView, state: Boolean) {
        if (state) view.setImageResource(R.drawable.ic_saved_48)
        else view.setImageResource(R.drawable.ic_unsaved_48)
    }
}