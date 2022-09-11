package jaesung.project.wanted_preonboarding_android.ui.save

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.databinding.ItemNewsBinding
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback

class SavedNewsAdapter(private val savedNewsClickListener: (News) -> Unit) : ListAdapter<News, SavedNewsAdapter.SavedNewsViewHolder>(
    ItemDiffCallback<News>(
        onContentSame = { old, new -> old.title == new.title },
        onItemSame = {old, new -> old == new}
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return SavedNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedNewsViewHolder, position: Int) {
        holder.bindItems(getItem(position), savedNewsClickListener)
    }

    class SavedNewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(item: News, savedNewsClickListener: (News) -> Unit) {
            binding.news = item
            binding.clContainer.setOnClickListener {
                savedNewsClickListener.invoke(item)
            }
            binding.executePendingBindings()
        }
    }
}