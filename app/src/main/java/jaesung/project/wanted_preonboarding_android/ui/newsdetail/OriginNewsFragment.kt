package jaesung.project.wanted_preonboarding_android.ui.newsdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentOriginNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateUp
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment

class OriginNewsFragment : BaseFragment<FragmentOriginNewsBinding>(R.layout.fragment_origin_news) {

    private val args: OriginNewsFragmentArgs by navArgs()
    private lateinit var newsUrl: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        newsUrl = args.newsUrl
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun bindViews() {
        binding.wvOriginNews.apply {
            WebViewClient()
            WebChromeClient()
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            loadUrl(newsUrl)
        }

        binding.tbOriginNews.setNavigationOnClickListener {
            navigateUp()
        }
    }
}