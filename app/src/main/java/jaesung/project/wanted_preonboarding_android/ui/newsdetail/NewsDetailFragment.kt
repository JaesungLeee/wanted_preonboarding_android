package jaesung.project.wanted_preonboarding_android.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.databinding.FragmentNewsDetailBinding
import jaesung.project.wanted_preonboarding_android.domain.model.News
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateUp
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithBundle
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(R.layout.fragment_news_detail) {

    private val args: NewsDetailFragmentArgs by navArgs()
    private lateinit var article: News

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        article = args.news

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    private fun bindViews() {
        binding.news = article
        binding.tbNewsDetail.setNavigationOnClickListener {
            navigateUp()
        }

        binding.btnUrl.setOnClickListener {
            navigateWithArgs(NewsDetailFragmentDirections.actionNewsDetailToOriginNews(article.newsUrl))
        }
    }
}