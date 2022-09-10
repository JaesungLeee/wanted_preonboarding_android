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
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentCategoryNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateUp
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import jaesung.project.wanted_preonboarding_android.util.UiState
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CategoryNewsFragment :
    BaseFragment<FragmentCategoryNewsBinding>(R.layout.fragment_category_news) {

    private val viewModel: CategoryViewModel by sharedViewModel()
    private val adapter: CategoryNewsAdapter by lazy {
        CategoryNewsAdapter { article ->
            navigateWithArgs(CategoryNewsFragmentDirections.actionCategoryNewsToNewsDetail(article))
        }
    }

    private lateinit var category: String
    private val args: CategoryNewsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        category = args.category

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadCategoryHeadlineNews(category)
        setToolbar()
        setRecyclerView()
        observe()
    }

    private fun setToolbar() {
        binding.tbCategoryNews.apply {
            title = category
            setNavigationOnClickListener {
                navigateUp()
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvCategoryNews.adapter = adapter
    }

    private fun observe() {
//        viewModel.newsCount.observe(viewLifecycleOwner) { count ->
//            setTextWithStyleSpan(count)
//        }
//
//        viewModel.error.observe(viewLifecycleOwner, EventObserver { error ->
//            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
//        })
//
//        viewModel.newsList.observe(viewLifecycleOwner) { newsList ->
//            with(binding.rvCategoryNews) {
//                adapter = categoryNewsAdapter.apply {
//                    submitList(newsList)
//                }
//                setHasFixedSize(true)
//            }
//        }

//        viewModel.headlineNews.flowWithLifecycle(lifecycle).onEach { uiState ->
//            when (uiState) {
//                is UiState.Success -> {
////                    setTextWithStyleSpan()
//                    adapter.submitList(uiState.data)
//                }
//                is UiState.Loading -> { }
//                is UiState.Error -> { }
//            }
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.headlineNews.collect { uiState ->
                    when (uiState) {
                        is UiState.Success -> {
//                    setTextWithStyleSpan()
                            adapter.submitList(uiState.data)
                        }
                        is UiState.Loading -> {}
                        is UiState.Error -> {}
                    }
                }
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
}