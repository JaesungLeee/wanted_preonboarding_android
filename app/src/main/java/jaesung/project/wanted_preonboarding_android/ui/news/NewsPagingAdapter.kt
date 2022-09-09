package jaesung.project.wanted_preonboarding_android.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.databinding.ItemNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback

class NewsPagingAdapter(private val newsClickListener: (Article) -> Unit) : PagingDataAdapter<Article, NewsPagingAdapter.NewsViewHolder>(
    ItemDiffCallback(
        onItemSame = { old, new -> old.newsTitle == new.newsTitle },
        onContentSame = { old, new -> old == new }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        getItem(position)?.let { article ->
            holder.bindItems(article, newsClickListener)
        }
    }


    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItems(article: Article, newsClickListener: (Article) -> Unit) {
            binding.article = article

            binding.clContainer.setOnClickListener {
                newsClickListener.invoke(article)
            }

            binding.executePendingBindings()
        }
    }
}