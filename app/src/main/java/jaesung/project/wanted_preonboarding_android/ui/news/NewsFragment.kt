package jaesung.project.wanted_preonboarding_android.ui.news

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.ViewModelFactory
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import jaesung.project.wanted_preonboarding_android.util.EventObserver

class NewsFragment : BaseFragment<FragmentNewsBinding>(R.layout.fragment_news) {

    private val viewModel: NewsViewModel by viewModels { ViewModelFactory(requireContext()) }
    private val adapter: NewsAdapter by lazy {
        NewsAdapter { article ->
            navigateWithArgs(NewsFragmentDirections.actionTopNewsToNewsDetail(article))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setRecyclerView()
    }

    private fun observe() {
        viewModel.error.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        viewModel.newsList.observe(viewLifecycleOwner) { news ->
            adapter.submitList(news)
        }
    }

    private fun setRecyclerView() {
        binding.rvNews.adapter = adapter
    }
}