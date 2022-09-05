package jaesung.project.wanted_preonboarding_android.ui.common

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback<T : Any>(
    val onItemSame: (T, T) -> Boolean,
    val onContentSame: (T, T) -> Boolean
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = onItemSame(oldItem, newItem)


    override fun areContentsTheSame(oldItem: T, newItem: T) = onContentSame(oldItem, newItem)

}