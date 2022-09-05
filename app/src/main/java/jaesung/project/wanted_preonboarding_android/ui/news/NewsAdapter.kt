package jaesung.project.wanted_preonboarding_android.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.databinding.ItemNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback

class NewsAdapter() : ListAdapter<Article, NewsAdapter.NewsViewHolder>(ItemDiffCallback<Article>(
    onItemSame = { old, new -> old.newsTitle == new.newsTitle },
    onContentSame = { old, new -> old == new }
)) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(article: Article) {
            binding.article = article
            binding.executePendingBindings()
        }
    }
}