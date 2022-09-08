package jaesung.project.wanted_preonboarding_android.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {
    private lateinit var binding: FragmentNewsDetailBinding

    private val args: NewsDetailFragmentArgs by navArgs()
    private lateinit var article: Article

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_detail, container, false)
        article = args.article
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.article = article
    }
}