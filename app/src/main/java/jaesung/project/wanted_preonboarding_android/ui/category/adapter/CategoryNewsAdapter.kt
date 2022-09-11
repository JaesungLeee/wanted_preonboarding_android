package jaesung.project.wanted_preonboarding_android.ui.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.databinding.ItemCategoryNewsBinding
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback

class CategoryNewsAdapter(private val newsClickListener: (News) -> Unit): ListAdapter<News, CategoryNewsAdapter.CategoryNewsViewHolder>(
    ItemDiffCallback<News>(
        onItemSame = { old, new -> old.title == new.title },
        onContentSame = { old, new -> old == new }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryNewsBinding.inflate(inflater, parent, false)
        return CategoryNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNewsViewHolder, position: Int) {
        holder.bindItems(getItem(position), newsClickListener)
    }

    class CategoryNewsViewHolder(private val binding: ItemCategoryNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(news: News, newsClickListener: (News) -> Unit) {

            binding.cvCategoryNews.setOnClickListener {
                newsClickListener.invoke(news)
            }

            binding.news = news
            binding.executePendingBindings()
        }
    }
}