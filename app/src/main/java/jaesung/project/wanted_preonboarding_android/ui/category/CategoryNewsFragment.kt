package jaesung.project.wanted_preonboarding_android.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateUp
import jaesung.project.wanted_preonboarding_android.util.Constants.CATEGORY_KEY

class CategoryNewsFragment : Fragment() {
    private lateinit var binding: FragmentCategoryNewsBinding

    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_news, container, false)

        category = arguments?.getString(CATEGORY_KEY) ?: ""
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        setToolbar()
    }

    private fun setToolbar() {
        binding.tbCategoryNews.apply {
            title = category
            setNavigationOnClickListener {
                navigateUp()
            }
        }
    }
}