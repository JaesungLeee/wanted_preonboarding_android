package jaesung.project.wanted_preonboarding_android.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.data.model.NewsCategory
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryGroupBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithBundle
import jaesung.project.wanted_preonboarding_android.ui.common.ViewModelFactory
import jaesung.project.wanted_preonboarding_android.util.Constants.CATEGORY_KEY

class CategoryGroupFragment : Fragment() {
    private lateinit var binding: FragmentCategoryGroupBinding

    private lateinit var categoryAdapter: CategoryAdapter
    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_group, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

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