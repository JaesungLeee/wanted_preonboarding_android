package jaesung.project.wanted_preonboarding_android.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentNewsDetailBinding
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateUp
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import jaesung.project.wanted_preonboarding_android.ui.news.NewsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(R.layout.fragment_news_detail) {

    private val args: NewsDetailFragmentArgs by navArgs()
    private lateinit var news: News

    private val viewModel: NewsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        news = args.news
        viewModel.isSaved.value = args.news.isSaved

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()

    }


    private fun bindViews() {
        binding.news = news
        binding.viewModel = viewModel

        binding.tbNewsDetail.setNavigationOnClickListener {
            navigateUp()
        }

        binding.btnUrl.setOnClickListener {
            navigateWithArgs(NewsDetailFragmentDirections.actionNewsDetailToOriginNews(news.newsUrl))
        }

        binding.ivSave.setOnClickListener {
            if (viewModel.isSaved.value == 1) {
                Timber.e("Deleted")
                Timber.e("${news.title}")
                viewModel.deleteNews(news.title)
            }
            else {
                Timber.e("clicked")
                viewModel.saveNews(news)
            }
        }
    }
}