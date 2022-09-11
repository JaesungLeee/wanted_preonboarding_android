package jaesung.project.wanted_preonboarding_android.ui.category

import android.os.Bundle
import android.view.View
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryGroupBinding
import jaesung.project.wanted_preonboarding_android.ui.category.adapter.CategoryAdapter
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CategoryGroupFragment :
    BaseFragment<FragmentCategoryGroupBinding>(R.layout.fragment_category_group) {

    private lateinit var categoryAdapter: CategoryAdapter
    private val viewModel: CategoryViewModel by sharedViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        val categoryList = loadCategoryList()

        initAdapter()

        binding.rvCategory.adapter = categoryAdapter.apply {
            submitList(categoryList)
        }
    }

    private fun initAdapter() {
        categoryAdapter = CategoryAdapter { category ->
            navigateWithArgs(CategoryGroupFragmentDirections.actionCategoryGroupToCategoryNews(category))
        }
    }

    private fun loadCategoryList() = viewModel.loadCategory()
}