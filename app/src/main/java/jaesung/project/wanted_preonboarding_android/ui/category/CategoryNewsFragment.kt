package jaesung.project.wanted_preonboarding_android.ui.category

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateUp
import jaesung.project.wanted_preonboarding_android.ui.common.ViewModelFactory
import jaesung.project.wanted_preonboarding_android.util.Constants.CATEGORY_KEY
import jaesung.project.wanted_preonboarding_android.util.EventObserver

class CategoryNewsFragment : Fragment() {
    private lateinit var binding: FragmentCategoryNewsBinding

    private lateinit var category: String
    private val viewModel: CategoryNewsViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var categoryNewsAdapter: CategoryNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_news, container, false)

        category = arguments?.getString(CATEGORY_KEY) ?: ""
        viewModel.category = category
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.loadCategoryHeadlines()
        setToolbar()
        initAdapter()
        observe()
    }

    private fun observe() {
        viewModel.newsCount.observe(viewLifecycleOwner) { count ->
            setTextWithStyleSpan(count)
        }

        viewModel.error.observe(viewLifecycleOwner, EventObserver { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        })

        viewModel.newsList.observe(viewLifecycleOwner) { newsList ->
            with(binding.rvCategoryNews) {
                adapter = categoryNewsAdapter.apply {
                    submitList(newsList)
                }
                setHasFixedSize(true)
            }
        }
    }

    private fun setTextWithStyleSpan(count: String) {
        val text = "About $count results for $category"
        val ssb = SpannableStringBuilder(text)

        val boldSpan = StyleSpan(Typeface.BOLD)
        val countStart = text.indexOf(count)
        val countEnd = countStart + count.length
        ssb.setSpan(boldSpan, countStart, countEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val colorSpan = ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.blue))
        val categoryStart = text.indexOf(category)
        val categoryEnd = categoryStart + category.length
        ssb.setSpan(colorSpan, categoryStart, categoryEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvCategoryNewsDescription.text = ssb
    }

    private fun initAdapter() {
        categoryNewsAdapter = CategoryNewsAdapter()
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