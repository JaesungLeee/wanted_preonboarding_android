package jaesung.project.wanted_preonboarding_android.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.databinding.ItemCategoryNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback

class CategoryNewsAdapter : ListAdapter<Article, CategoryNewsAdapter.CategoryNewsViewHolder>(
    ItemDiffCallback<Article>(
        onItemSame = { old, new -> old.newsTitle == new.newsTitle },
        onContentSame = { old, new -> old == new }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryNewsBinding.inflate(inflater, parent, false)
        return CategoryNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNewsViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class CategoryNewsViewHolder(private val binding: ItemCategoryNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(article: Article) {
            binding.news = article
            binding.executePendingBindings()
        }

    }
}