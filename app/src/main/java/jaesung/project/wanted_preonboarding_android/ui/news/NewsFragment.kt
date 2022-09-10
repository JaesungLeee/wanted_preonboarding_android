package jaesung.project.wanted_preonboarding_android.ui.news

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import jaesung.project.wanted_preonboarding_android.util.UiState
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsFragment : BaseFragment<FragmentNewsBinding>(R.layout.fragment_news) {

    private val viewModel: NewsViewModel by viewModel()
    private val adapter: NewsAdapter by lazy {
        NewsAdapter { news ->
            navigateWithArgs(NewsFragmentDirections.actionTopNewsToNewsDetail(news))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadHeadlineNews()
        observe()

    }

    private fun observe() {
//        viewModel.headlineNews.flowWithLifecycle(lifecycle).onEach { uiState ->
//            when (uiState) {
//                is UiState.Success -> {
//                    setRecyclerView()
//                    Timber.e("${uiState.data}")
//                    adapter.submitList(uiState.data)
//                }
//                is UiState.Error -> { }
//                is UiState.Loading -> { }
//            }
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.headlineNews.collect { uiState ->
                    when (uiState) {
                        is UiState.Success -> {
                            setRecyclerView()
                            Timber.e("${uiState.data}")
                            adapter.submitList(uiState.data)
                        }
                        is UiState.Error -> {}
                        is UiState.Loading -> {}
                    }
                }
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvNews.adapter = adapter
    }
}