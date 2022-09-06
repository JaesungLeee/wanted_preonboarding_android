package jaesung.project.wanted_preonboarding_android.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryGroupBinding
import jaesung.project.wanted_preonboarding_android.ui.common.ViewModelFactory

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
        val categoryList = viewModel.loadCategory()

        categoryAdapter = CategoryAdapter()
        
        binding.rvCategory.adapter = categoryAdapter.apply {
            submitList(categoryList)
        }
    }
}