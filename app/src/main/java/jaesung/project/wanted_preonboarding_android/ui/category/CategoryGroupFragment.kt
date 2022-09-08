package jaesung.project.wanted_preonboarding_android.ui.category

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryGroupBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithBundle
import jaesung.project.wanted_preonboarding_android.ui.common.ViewModelFactory
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import jaesung.project.wanted_preonboarding_android.util.Constants.CATEGORY_KEY

class CategoryGroupFragment :
    BaseFragment<FragmentCategoryGroupBinding>(R.layout.fragment_category_group) {

    private lateinit var categoryAdapter: CategoryAdapter
    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }


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
            navigateWithBundle(
                R.id.action_category_group_to_category_news, bundleOf(
                    CATEGORY_KEY to category
                )
            )
        }
    }

    private fun loadCategoryList() = viewModel.loadCategory()
}