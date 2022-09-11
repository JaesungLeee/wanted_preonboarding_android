package jaesung.project.wanted_preonboarding_android.ui.save

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import jaesung.project.wanted_preonboarding_android.R
import jaesung.project.wanted_preonboarding_android.databinding.FragmentSaveNewsBinding
import jaesung.project.wanted_preonboarding_android.ui.common.NavigationUtil.navigateWithArgs
import jaesung.project.wanted_preonboarding_android.ui.common.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SaveNewsFragment : BaseFragment<FragmentSaveNewsBinding>(R.layout.fragment_save_news) {

    private val viewModel: SavedViewModel by viewModel()
    private val adapter: SavedNewsAdapter by lazy {
        SavedNewsAdapter {
            navigateWithArgs(SaveNewsFragmentDirections.actionSavedToNewsDetail(it))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        observeSavedNews()
        viewModel.loadSavedNews()
    }

    private fun observeSavedNews() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.savedNews.collect {
                    Timber.e("$it")
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvSavedNews.adapter = adapter
    }


}