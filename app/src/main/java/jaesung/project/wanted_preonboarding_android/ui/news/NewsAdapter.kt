package jaesung.project.wanted_preonboarding_android.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.databinding.ItemNewsBinding
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback

class NewsAdapter(private val newsClickListener: (News) -> Unit) : ListAdapter<News, NewsAdapter.NewsViewHolder>(ItemDiffCallback<News>(
    onItemSame = { old, new -> old.title == new.title },
    onContentSame = { old, new -> old == new }
)) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindItems(getItem(position), newsClickListener)
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(news: News, newsClickListener: (News) -> Unit) {
            binding.news = news

            binding.clContainer.setOnClickListener {
                newsClickListener.invoke(news)
            }
            binding.executePendingBindings()
        }
    }
}