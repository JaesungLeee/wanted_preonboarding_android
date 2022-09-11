package jaesung.project.wanted_preonboarding_android.ui.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory
import jaesung.project.wanted_preonboarding_android.databinding.ItemCategoryGroupBinding
import jaesung.project.wanted_preonboarding_android.ui.common.ItemDiffCallback
import timber.log.Timber

class CategoryAdapter(private val categoryClickListener: (String) -> Unit) : ListAdapter<NewsCategory, CategoryAdapter.CategoryViewHolder>(
    ItemDiffCallback<NewsCategory>(
        onItemSame = { old, new -> old.category == new.category },
        onContentSame = { old, new -> old == new }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryGroupBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindItems(getItem(position), categoryClickListener)
    }

    class CategoryViewHolder(private val binding: ItemCategoryGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(newsCategory: NewsCategory, categoryClickListener: (String) -> Unit) {
            Timber.e("$newsCategory")
            binding.newsCategory = newsCategory

            binding.clCategory.setOnClickListener {
                categoryClickListener.invoke(newsCategory.category)
            }

            binding.executePendingBindings()
        }

    }
}